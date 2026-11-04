package me.rerere.rikkahub.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * 聊天界面专属配色，独立于 Material 3 ColorScheme。
 * 所有字段都是可选的：null = fallback 到主题色。
 */
data class ChatColorScheme(
    // 气泡
    val userBubble: Color? = null,
    val onUserBubble: Color? = null,
    val assistantBubble: Color? = null,
    val onAssistantBubble: Color? = null,

    // 底部输入区
    val inputBarBackground: Color? = null,
    val inputFieldBackground: Color? = null,
    val inputFieldText: Color? = null,
    val inputFieldPlaceholder: Color? = null,

    // 按钮
    val plusIconColor: Color? = null,
    val aiStarIconColor: Color? = null,
    val aiStarBackground: Color? = null,
    val sendButtonBackground: Color? = null,
    val sendButtonIcon: Color? = null,
    val sendButtonBackgroundEmpty: Color? = null,
    val sendButtonIconEmpty: Color? = null,

    // 聊天区
    val chatBackground: Color? = null,
    val timestampText: Color? = null,
)

val LocalChatColorScheme = compositionLocalOf { ChatColorScheme() }

/** 用户气泡候选色 A「雾粉白」 */
val WarmHomeUserBubbleA = Color(0xFFF8F0EF)
/** 用户气泡候选色 B「晨雾玫瑰」（默认） */
val WarmHomeUserBubbleB = Color(0xFFF5EAE8)

/**
 * 暖屋 · 晨光玫瑰 浅色聊天配色
 * userBubble 由外部根据 A/B 设置传入
 */
fun warmHomeLightChatColors(userBubble: Color = WarmHomeUserBubbleB) = ChatColorScheme(
    // 气泡
    userBubble = userBubble,
    onUserBubble = Color(0xFF514B49),
    assistantBubble = Color(0xFFF5F2F0),
    onAssistantBubble = Color(0xFF514B49),

    // 底部输入区
    inputBarBackground = Color(0xFFF0EFEE),
    inputFieldBackground = Color(0xFFFFFFFF),
    inputFieldText = Color(0xFF514B49),
    inputFieldPlaceholder = Color(0xFFB6ABA8),

    // 按钮
    plusIconColor = Color(0xFF8C7F7C),
    aiStarIconColor = Color(0xFF9F8582),
    aiStarBackground = Color(0xFFEAE3E1),
    sendButtonBackground = Color(0xFFD9A3A3),
    sendButtonIcon = Color(0xFFFFFFFF),
    sendButtonBackgroundEmpty = Color(0xFFF8F6F5),
    sendButtonIconEmpty = Color(0xFFB8AEAB),

    // 聊天区
    chatBackground = Color(0xFFFBFAF9),
    timestampText = Color(0xFFA8A09D),
)

/**
 * 暖屋 · 晨光玫瑰 深色聊天配色（placeholder）
 */
val WarmHomeDarkChatColors = ChatColorScheme()

/**
 * 便捷方法：读取聊天配色，有自定义值就用，没有就 fallback 到主题色。
 */
object ChatColors {
    val userBubble: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.userBubble
            ?: MaterialTheme.colorScheme.primaryContainer

    val onUserBubble: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.onUserBubble
            ?: MaterialTheme.colorScheme.onPrimaryContainer

    val assistantBubble: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.assistantBubble
            ?: MaterialTheme.colorScheme.secondaryContainer

    val onAssistantBubble: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.onAssistantBubble
            ?: MaterialTheme.colorScheme.onSecondaryContainer

    val inputBarBackground: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.inputBarBackground
            ?: MaterialTheme.colorScheme.surfaceContainerLow

    val inputFieldBackground: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.inputFieldBackground
            ?: MaterialTheme.colorScheme.surface

    val inputFieldText: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.inputFieldText
            ?: MaterialTheme.colorScheme.onSurface

    val inputFieldPlaceholder: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.inputFieldPlaceholder
            ?: MaterialTheme.colorScheme.onSurfaceVariant

    val plusIconColor: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.plusIconColor
            ?: MaterialTheme.colorScheme.onSurfaceVariant

    val aiStarIconColor: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.aiStarIconColor
            ?: MaterialTheme.colorScheme.primary

    val aiStarBackground: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.aiStarBackground
            ?: MaterialTheme.colorScheme.primaryContainer

    val sendButtonBackground: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.sendButtonBackground
            ?: MaterialTheme.colorScheme.primary

    val sendButtonIcon: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.sendButtonIcon
            ?: MaterialTheme.colorScheme.onPrimary

    val sendButtonBackgroundEmpty: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.sendButtonBackgroundEmpty
            ?: MaterialTheme.colorScheme.surfaceContainerHigh

    val sendButtonIconEmpty: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.sendButtonIconEmpty
            ?: MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)

    val chatBackground: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.chatBackground
            ?: MaterialTheme.colorScheme.background

    val timestampText: Color
        @Composable @ReadOnlyComposable
        get() = LocalChatColorScheme.current.timestampText
            ?: MaterialTheme.colorScheme.onSurfaceVariant
}
