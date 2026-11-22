package me.rerere.rikkahub.ui.theme.mercury.presets

import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import me.rerere.rikkahub.ui.theme.PresetTheme
import me.rerere.rikkahub.ui.theme.mercury.MercuryChatColors
import me.rerere.rikkahub.ui.theme.mercury.MercuryRoleColors
import me.rerere.rikkahub.ui.theme.mercury.MercurySettingsColors
import me.rerere.rikkahub.ui.theme.mercury.MercurySidebarColors
import me.rerere.rikkahub.ui.theme.mercury.MercuryTheme
import me.rerere.rikkahub.ui.theme.mercury.MercuryThemeColors

/**
 * 晨光玫瑰 — first independent Mercury preset.
 *
 * The 35+35 Material 3 foundation colors below are a TEMPORARY, frozen
 * starting palette. They are intentionally copied into Mercury's own file,
 * not referenced from Sakura, and are NOT approved Morning Rose values.
 * Replace each role as that part of the UI is designed.
 *
 * Only the explicit light sidebar and role-list overrides below are approved.
 * Other screen tokens and the dark palette are temporary scaffolding.
 */
private val lightScheme = lightColorScheme(
    primary = Color(0xFF8E4955),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFD9DD),
    onPrimaryContainer = Color(0xFF72333E),
    secondary = Color(0xFF76565A),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFFD9DD),
    onSecondaryContainer = Color(0xFF5C3F43),
    tertiary = Color(0xFF785831),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFDDB8),
    onTertiaryContainer = Color(0xFF5E411C),
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF93000A),
    background = Color(0xFFFFF8F7),
    onBackground = Color(0xFF22191A),
    surface = Color(0xFFFFF8F7),
    onSurface = Color(0xFF22191A),
    surfaceVariant = Color(0xFFF3DDDF),
    onSurfaceVariant = Color(0xFF524345),
    outline = Color(0xFF847374),
    outlineVariant = Color(0xFFD7C1C3),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFF382E2F),
    inverseOnSurface = Color(0xFFFEEDED),
    inversePrimary = Color(0xFFFFB2BC),
    surfaceDim = Color(0xFFE7D6D7),
    surfaceBright = Color(0xFFFFF8F7),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFFFF0F1),
    surfaceContainer = Color(0xFFFBEAEB),
    surfaceContainerHigh = Color(0xFFF6E4E5),
    surfaceContainerHighest = Color(0xFFF0DEDF),
)

private val darkScheme = darkColorScheme(
    primary = Color(0xFFFFB2BC),
    onPrimary = Color(0xFF561D28),
    primaryContainer = Color(0xFF72333E),
    onPrimaryContainer = Color(0xFFFFD9DD),
    secondary = Color(0xFFE5BDC1),
    onSecondary = Color(0xFF43292D),
    secondaryContainer = Color(0xFF5C3F43),
    onSecondaryContainer = Color(0xFFFFD9DD),
    tertiary = Color(0xFFEABF8F),
    onTertiary = Color(0xFF452B07),
    tertiaryContainer = Color(0xFF5E411C),
    onTertiaryContainer = Color(0xFFFFDDB8),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF1A1112),
    onBackground = Color(0xFFF0DEDF),
    surface = Color(0xFF1A1112),
    onSurface = Color(0xFFF0DEDF),
    surfaceVariant = Color(0xFF524345),
    onSurfaceVariant = Color(0xFFD7C1C3),
    outline = Color(0xFF9F8C8E),
    outlineVariant = Color(0xFF524345),
    scrim = Color(0xFF000000),
    inverseSurface = Color(0xFFF0DEDF),
    inverseOnSurface = Color(0xFF382E2F),
    inversePrimary = Color(0xFF8E4955),
    surfaceDim = Color(0xFF1A1112),
    surfaceBright = Color(0xFF413738),
    surfaceContainerLowest = Color(0xFF140C0D),
    surfaceContainerLow = Color(0xFF22191A),
    surfaceContainer = Color(0xFF261D1E),
    surfaceContainerHigh = Color(0xFF312828),
    surfaceContainerHighest = Color(0xFF3D3233),
)

// Deliberately separate fields: matching HEX values do not imply a shared token.
private val lightMercuryColors = MercuryThemeColors(
    sidebar = MercurySidebarColors(
        background = Color(0xFFFCFBFC),
        // Level-1 navigation
        primaryNormalText = Color(0xFF514247),
        primarySelectedText = Color(0xFFA16D7E),
        primaryNormalIcon = Color(0xFF81797B),
        primarySelectedIcon = Color(0xFFA16D7E),
        // Level-2 navigation
        secondaryNormalText = Color(0xFF5D5357),
        secondarySelectedText = Color(0xFFA77585),
        // Shared
        selectedBackground = Color(0xFFFAF0F1),
        chevronColor = Color(0xFF91898B),
        // User profile
        nicknameColor = Color(0xFF514247),
        greetingColor = Color(0xFF91898B),
        avatarPlaceholderBackground = Color(0xFFF5F1F0),
        avatarPlaceholderIcon = Color(0xFFAD8790),
        // Conversation list (kept for future)
        conversationBackground = Color(0xFFFFF8F7),
        conversationSelectedBackground = Color(0xFFF6E4E5),
        folderBackground = Color(0xFFFFF0F1),
        folderSelectedBackground = Color(0xFFFFD9DD),
    ),
    chat = MercuryChatColors(
        background = Color(0xFFFFF8F7),
        userBubble = Color(0xFFFFD9DD),
        assistantBubble = Color(0xFFF6E4E5),
        inputBackground = Color(0xFFFFF0F1),
        inputBorder = Color(0xFFD7C1C3),
        topBarBackground = Color(0xFFFFF0F1),
        aiReplyIcon = Color(0xFF8E4955),
        sendIcon = Color(0xFF524345),
    ),
    roles = MercuryRoleColors(
        listBackground = Color(0xFFFCFBFC),
        selectedBackground = Color(0xFFFAF0F1),
        nameContent = Color(0xFF514247),
        addIcon = Color(0xFFAC7181),
    ),
    settings = MercurySettingsColors(
        pageBackground = Color(0xFFFFF8F7),
        cardBackground = Color(0xFFFFF8F7),
        itemIcon = Color(0xFF524345),
        sectionTitle = Color(0xFF8E4955),
    ),
)

private val darkMercuryColors = MercuryThemeColors(
    sidebar = MercurySidebarColors(
        background = Color(0xFF1A1112),
        primaryNormalText = Color(0xFFF0DEDF),
        primarySelectedText = Color(0xFFFFD9DD),
        primaryNormalIcon = Color(0xFFF0DEDF),
        primarySelectedIcon = Color(0xFFFFD9DD),
        secondaryNormalText = Color(0xFFF0DEDF),
        secondarySelectedText = Color(0xFFFFD9DD),
        selectedBackground = Color(0xFF5C3F43),
        chevronColor = Color(0xFF9F8C8E),
        nicknameColor = Color(0xFFF0DEDF),
        greetingColor = Color(0xFF9F8C8E),
        avatarPlaceholderBackground = Color(0xFF312828),
        avatarPlaceholderIcon = Color(0xFFFFB2BC),
        conversationBackground = Color(0xFF1A1112),
        conversationSelectedBackground = Color(0xFF312828),
        folderBackground = Color(0xFF22191A),
        folderSelectedBackground = Color(0xFF5C3F43),
    ),
    chat = MercuryChatColors(
        background = Color(0xFF1A1112),
        userBubble = Color(0xFF72333E),
        assistantBubble = Color(0xFF312828),
        inputBackground = Color(0xFF22191A),
        inputBorder = Color(0xFF524345),
        topBarBackground = Color(0xFF22191A),
        aiReplyIcon = Color(0xFFFFB2BC),
        sendIcon = Color(0xFFD7C1C3),
    ),
    roles = MercuryRoleColors(
        listBackground = Color(0xFF1A1112),
        selectedBackground = Color(0xFF312828),
        nameContent = Color(0xFFF0DEDF),
        addIcon = Color(0xFFFFB2BC),
    ),
    settings = MercurySettingsColors(
        pageBackground = Color(0xFF1A1112),
        cardBackground = Color(0xFF413738),
        itemIcon = Color(0xFFD7C1C3),
        sectionTitle = Color(0xFFFFB2BC),
    ),
)

val MorningRoseTheme by lazy {
    MercuryTheme(
        preset = PresetTheme(
            id = "mercury.morning_rose",
            name = { Text("晨光玫瑰") },
            standardLight = lightScheme,
            standardDark = darkScheme,
        ),
        lightColors = lightMercuryColors,
        darkColors = darkMercuryColors,
    )
}
