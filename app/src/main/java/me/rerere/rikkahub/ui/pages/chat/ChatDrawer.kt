package me.rerere.rikkahub.ui.pages.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.rerere.rikkahub.R
import me.rerere.rikkahub.Screen
import me.rerere.rikkahub.data.model.Avatar
import me.rerere.rikkahub.data.datastore.Settings
import me.rerere.rikkahub.ui.components.ui.UIAvatar
import me.rerere.rikkahub.ui.context.Navigator
import me.rerere.rikkahub.ui.hooks.EditStateContent
import me.rerere.rikkahub.ui.hooks.useEditState
import me.rerere.rikkahub.ui.theme.mercury.LocalMercuryColors

// ──────────────────────────────────────────────
// Mercury sidebar menu data
// ──────────────────────────────────────────────

private data class SidebarMenu(
    val id: String,
    val label: String,
    val iconRes: Int,
    val children: List<SidebarChild> = emptyList(),
    val screen: Screen? = null, // null = no navigation (placeholder)
)

private data class SidebarChild(
    val label: String,
    val screen: Screen? = null,
)

private fun buildMenus(): List<SidebarMenu> = listOf(
    SidebarMenu(
        id = "chat",
        label = "聊天",
        iconRes = R.drawable.mercury_message_circle,
        children = listOf(
            SidebarChild("对话"), // closes drawer, stays on current chat
            SidebarChild("聊天记录", Screen.History),
            SidebarChild("我的收藏", Screen.Favorite),
            SidebarChild("聊天统计", Screen.Stats),
        ),
    ),
    SidebarMenu(id = "roles", label = "角色", iconRes = R.drawable.mercury_users, screen = Screen.Assistant),
    SidebarMenu(id = "calendar", label = "日历", iconRes = R.drawable.mercury_calendar_days),
    SidebarMenu(id = "notes", label = "手记", iconRes = R.drawable.mercury_notebook_pen),
    SidebarMenu(id = "album", label = "相册", iconRes = R.drawable.mercury_images),
    SidebarMenu(
        id = "leisure",
        label = "休闲",
        iconRes = R.drawable.mercury_coffee,
        children = listOf(
            SidebarChild("音乐"),
            SidebarChild("阅读"),
            SidebarChild("游戏"),
        ),
    ),
    SidebarMenu(id = "explore", label = "探索", iconRes = R.drawable.mercury_compass),
    SidebarMenu(
        id = "tools",
        label = "工具",
        iconRes = R.drawable.mercury_wrench,
        children = listOf(
            SidebarChild("媒体创作", Screen.MediaCreationSessions),
            SidebarChild("AI 翻译", Screen.Translator),
        ),
    ),
    SidebarMenu(id = "settings", label = "设置", iconRes = R.drawable.mercury_settings, screen = Screen.Setting),
)

// ──────────────────────────────────────────────
// Main drawer composable
// ──────────────────────────────────────────────

@Composable
fun ChatDrawerContent(
    navController: Navigator,
    vm: ChatVM,
    settings: Settings,
    current: me.rerere.rikkahub.data.model.Conversation? = null,
) {
    val mercuryColors = LocalMercuryColors.current
    val sidebarColors = mercuryColors?.sidebar

    val menus = remember { buildMenus() }

    // Which parent group is currently expanded (at most one at a time).
    // Resets every time the drawer opens because rememberSaveable persists
    // only within the composition lifetime of the drawer sheet.
    var expandedId by rememberSaveable { mutableStateOf<String?>(null) }

    // Nickname editing
    val nicknameEditState = useEditState<String> { newNickname ->
        vm.updateSettings {
            it.copy(
                displaySetting = it.displaySetting.copy(
                    userNickname = newNickname
                )
            )
        }
    }

    ModalDrawerSheet(
        modifier = Modifier.width(300.dp),
        drawerContainerColor = sidebarColors?.background
            ?: MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            // ── User profile header ──
            UserProfileHeader(
                settings = settings,
                sidebarColors = sidebarColors,
                onEditNickname = {
                    nicknameEditState.open(settings.displaySetting.userNickname)
                },
                onUpdateAvatar = { newAvatar ->
                    vm.updateSettings {
                        it.copy(
                            displaySetting = it.displaySetting.copy(
                                userAvatar = newAvatar
                            )
                        )
                    }
                },
            )

            Spacer(Modifier.height(12.dp))

            // ── Navigation menu ──
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                menus.forEach { menu ->
                    val hasChildren = menu.children.isNotEmpty()
                    val isExpanded = expandedId == menu.id
                    // A parent is "active" if the current page belongs to it
                    // For now we don't track the current route, so no highlight.
                    // The expanded parent shows normal colors; only the selected
                    // child gets the highlight (design spec §三.4).

                    // Level-1 row
                    PrimaryMenuItem(
                        menu = menu,
                        isExpanded = isExpanded,
                        isParentHighlighted = false, // future: track route
                        sidebarColors = sidebarColors,
                        onClick = {
                            if (hasChildren) {
                                expandedId = if (isExpanded) null else menu.id
                            } else {
                                menu.screen?.let {
                                    navController.navigate(it)
                                }
                            }
                        },
                    )

                    // Level-2 children
                    AnimatedVisibility(
                        visible = isExpanded,
                        enter = expandVertically(),
                        exit = shrinkVertically(),
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 40.dp, top = 2.dp, bottom = 2.dp),
                            verticalArrangement = Arrangement.spacedBy(0.dp),
                        ) {
                            menu.children.forEach { child ->
                                SecondaryMenuItem(
                                    child = child,
                                    isSelected = false, // future: track route
                                    sidebarColors = sidebarColors,
                                    onClick = {
                                        if (child.screen != null) {
                                            navController.navigate(child.screen)
                                        }
                                    },
                                )
                            }
                        }
                    }
                }
                }
            }

        }

    // ── Nickname edit dialog ──
    nicknameEditState.EditStateContent { nickname, onUpdate ->
        AlertDialog(
            onDismissRequest = { nicknameEditState.dismiss() },
            title = { Text(stringResource(R.string.chat_page_edit_nickname)) },
            text = {
                OutlinedTextField(
                    value = nickname,
                    onValueChange = onUpdate,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    placeholder = { Text(stringResource(R.string.chat_page_nickname_placeholder)) },
                )
            },
            confirmButton = {
                TextButton(onClick = { nicknameEditState.confirm() }) {
                    Text(stringResource(R.string.chat_page_save))
                }
            },
            dismissButton = {
                TextButton(onClick = { nicknameEditState.dismiss() }) {
                    Text(stringResource(R.string.chat_page_cancel))
                }
            },
        )
    }
}

// ──────────────────────────────────────────────
// User profile header
// ──────────────────────────────────────────────

@Composable
private fun UserProfileHeader(
    settings: Settings,
    sidebarColors: me.rerere.rikkahub.ui.theme.mercury.MercurySidebarColors?,
    onEditNickname: () -> Unit,
    onUpdateAvatar: (Avatar) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        UIAvatar(
            name = settings.displaySetting.userNickname.ifBlank {
                stringResource(R.string.user_default_name)
            },
            value = settings.displaySetting.userAvatar,
            onUpdate = onUpdateAvatar,
            modifier = Modifier.size(44.dp),
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.weight(1f),
        ) {
            // Nickname – clickable, no pencil icon
            Text(
                text = settings.displaySetting.userNickname.ifBlank {
                    stringResource(R.string.user_default_name)
                },
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = sidebarColors?.nicknameColor
                    ?: MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.clickable { onEditNickname() },
            )

            // Dynamic greeting
            Greeting(
                color = sidebarColors?.greetingColor
                    ?: MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

// ──────────────────────────────────────────────
// Level-1 menu item
// ──────────────────────────────────────────────

@Composable
private fun PrimaryMenuItem(
    menu: SidebarMenu,
    isExpanded: Boolean,
    isParentHighlighted: Boolean,
    sidebarColors: me.rerere.rikkahub.ui.theme.mercury.MercurySidebarColors?,
    onClick: () -> Unit,
) {
    val hasChildren = menu.children.isNotEmpty()
    val showHighlight = isParentHighlighted && !isExpanded

    val textColor = if (showHighlight) {
        sidebarColors?.primarySelectedText ?: MaterialTheme.colorScheme.primary
    } else {
        sidebarColors?.primaryNormalText ?: MaterialTheme.colorScheme.onSurface
    }
    val iconColor = if (showHighlight) {
        sidebarColors?.primarySelectedIcon ?: MaterialTheme.colorScheme.primary
    } else {
        sidebarColors?.primaryNormalIcon ?: MaterialTheme.colorScheme.onSurfaceVariant
    }
    val bgColor = if (showHighlight) {
        sidebarColors?.selectedBackground ?: MaterialTheme.colorScheme.secondaryContainer
    } else {
        Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Icon(
            painter = painterResource(menu.iconRes),
            contentDescription = menu.label,
            modifier = Modifier.size(22.dp),
            tint = iconColor,
        )

        Text(
            text = menu.label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = textColor,
            modifier = Modifier.weight(1f),
        )

        if (hasChildren) {
            Icon(
                painter = painterResource(
                    if (isExpanded) R.drawable.mercury_chevron_down
                    else R.drawable.mercury_chevron_right
                ),
                contentDescription = if (isExpanded) "收起" else "展开",
                modifier = Modifier.size(16.dp),
                tint = sidebarColors?.chevronColor
                    ?: MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

// ──────────────────────────────────────────────
// Level-2 menu item
// ──────────────────────────────────────────────

@Composable
private fun SecondaryMenuItem(
    child: SidebarChild,
    isSelected: Boolean,
    sidebarColors: me.rerere.rikkahub.ui.theme.mercury.MercurySidebarColors?,
    onClick: () -> Unit,
) {
    val textColor = if (isSelected) {
        sidebarColors?.secondarySelectedText ?: MaterialTheme.colorScheme.primary
    } else {
        sidebarColors?.secondaryNormalText ?: MaterialTheme.colorScheme.onSurface
    }
    val bgColor = if (isSelected) {
        sidebarColors?.selectedBackground ?: MaterialTheme.colorScheme.secondaryContainer
    } else {
        Color.Transparent
    }
    val fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal

    Text(
        text = child.label,
        fontSize = 15.sp,
        fontWeight = fontWeight,
        color = textColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 8.dp),
    )
}

// ──────────────────────────────────────────────
// Greeting (reused from original)
// ──────────────────────────────────────────────

@Composable
private fun Greeting(
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
) {
    val hour = remember { java.time.LocalTime.now().hour }
    val greeting = when (hour) {
        in 5..8 -> "早上好，欢迎回家 ♡"
        in 9..11 -> "上午好，欢迎回家 ♡"
        in 12..13 -> "中午好，欢迎回家 ♡"
        in 14..17 -> "下午好，欢迎回家 ♡"
        in 18..21 -> "晚上好，欢迎回家 ♡"
        else -> "夜深了，欢迎回家 ♡"
    }
    Text(
        text = greeting,
        fontSize = 13.sp,
        color = color,
        maxLines = 1,
    )
}
