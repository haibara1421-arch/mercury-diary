package me.rerere.rikkahub.ui.theme.mercury

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Water-tight, per-screen color tokens for Mercury themes.
 *
 * Different components deliberately have different fields even when their
 * starting colors match. Changing one token must not recolor other screens.
 * Add a dedicated token when a new component needs independent control.
 */
data class MercurySidebarColors(
    val background: Color,
    val navigationSelectedBackground: Color,
    val navigationNormalContent: Color,
    val navigationSelectedContent: Color,
    val conversationBackground: Color,
    val conversationSelectedBackground: Color,
    val folderBackground: Color,
    val folderSelectedBackground: Color,
)

data class MercuryChatColors(
    val background: Color,
    val userBubble: Color,
    val assistantBubble: Color,
    val inputBackground: Color,
    val inputBorder: Color,
    val topBarBackground: Color,
    val aiReplyIcon: Color,
    val sendIcon: Color,
)

data class MercuryRoleColors(
    val listBackground: Color,
    val selectedBackground: Color,
    val nameContent: Color,
    val addIcon: Color,
)

data class MercurySettingsColors(
    val pageBackground: Color,
    val cardBackground: Color,
    val itemIcon: Color,
    val sectionTitle: Color,
)

data class MercuryThemeColors(
    val sidebar: MercurySidebarColors,
    val chat: MercuryChatColors,
    val roles: MercuryRoleColors,
    val settings: MercurySettingsColors,
)

/**
 * Null for all classic presets, imported custom themes and system dynamic
 * colors. Those themes continue using the existing Material 3 color path.
 */
val LocalMercuryColors = compositionLocalOf<MercuryThemeColors?> { null }

val MaterialTheme.mercuryColors: MercuryThemeColors?
    @Composable
    @ReadOnlyComposable
    get() = LocalMercuryColors.current
