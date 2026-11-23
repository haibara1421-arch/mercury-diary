package me.rerere.rikkahub.ui.pages.assistant

import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.rerere.rikkahub.data.datastore.Settings
import me.rerere.rikkahub.data.datastore.SettingsStore
import me.rerere.rikkahub.data.files.FilesManager
import me.rerere.rikkahub.data.model.Assistant
import me.rerere.rikkahub.data.model.Avatar
import me.rerere.rikkahub.data.repository.ConversationRepository
import me.rerere.rikkahub.data.repository.MemoryRepository
import me.rerere.rikkahub.data.repository.memoryId
import me.rerere.rikkahub.service.ChatService
import kotlinx.coroutines.flow.first
import kotlin.uuid.Uuid

class AssistantVM(
    private val settingsStore: SettingsStore,
    private val memoryRepository: MemoryRepository,
    private val chatService: ChatService,
    private val filesManager: FilesManager,
    private val conversationRepository: ConversationRepository,
) : ViewModel() {
    val settings: StateFlow<Settings> = settingsStore.settingsFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, Settings.dummy())

    fun updateSettings(fn: (Settings) -> Settings) {
        viewModelScope.launch {
            settingsStore.update(fn)
        }
    }

    fun addAssistant(assistant: Assistant) {
        viewModelScope.launch {
            settingsStore.update { it.copy(assistants = it.assistants.plus(assistant)) }
        }
    }

    fun removeAssistant(assistant: Assistant) {
        viewModelScope.launch {
            cleanupAssistantFiles(assistant)

            settingsStore.update { settings ->
                settings.copy(assistants = settings.assistants.filter { it.id != assistant.id })
            }
            memoryRepository.deleteFilesOfAssistant(assistant.id.toString())
            chatService.deleteConversationsOfAssistant(assistant.id)
        }
    }

    private fun cleanupAssistantFiles(assistant: Assistant) {
        val uris = buildList {
            (assistant.avatar as? Avatar.Image)?.let { add(it.url.toUri()) }
            assistant.background?.let { add(it.toUri()) }
        }

        if (uris.isNotEmpty()) {
            filesManager.deleteChatFiles(uris)
        }
    }

    fun copyAssistant(assistant: Assistant, copyMemories: Boolean = false) {
        viewModelScope.launch {
            val copiedAssistant = assistant.copy(
                id = kotlin.uuid.Uuid.random(),
                name = "${assistant.name} (Clone)",
                avatar = if(assistant.avatar is Avatar.Image) Avatar.Dummy else assistant.avatar,
            )
            settingsStore.update { it.copy(assistants = it.assistants.plus(copiedAssistant)) }
            if (copyMemories) {
                memoryRepository.copyFiles(
                    fromAssistantId = assistant.id.toString(),
                    toAssistantId = copiedAssistant.id.toString(),
                )
            }
        }
    }

    fun getMemories(assistant: Assistant) = memoryRepository.getFilesFlow(assistant.memoryId)

    /**
     * Switch the active assistant and return a conversation ID to navigate to.
     * If the user prefers creating a new conversation on start, returns a fresh UUID;
     * otherwise returns the most recent existing conversation for this assistant.
     */
    suspend fun selectAssistant(assistant: Assistant, createNewOnStart: Boolean): Uuid {
        settingsStore.update { it.copy(assistantId = assistant.id) }
        return if (createNewOnStart) {
            Uuid.random()
        } else {
            conversationRepository.getConversationsOfAssistant(assistant.id)
                .first()
                .firstOrNull()
                ?.id ?: Uuid.random()
        }
    }
}
