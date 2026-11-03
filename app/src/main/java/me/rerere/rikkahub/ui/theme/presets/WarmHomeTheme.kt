package me.rerere.rikkahub.ui.theme.presets

import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import me.rerere.rikkahub.ui.theme.PresetTheme

val WarmHomeThemePreset by lazy {
    PresetTheme(
        id = "warm_home",
        name = {
            Text("暖屋 · 晨光玫瑰")
        },
        standardLight = lightScheme,
        standardDark = darkScheme,
    )
}

//region Warm Home Light Colors
private val primaryLight = Color(0xFFD9A3A3)
private val onPrimaryLight = Color(0xFFFFFFFF)
private val primaryContainerLight = Color(0xFFF7E8E6)
private val onPrimaryContainerLight = Color(0xFF684C4B)

private val secondaryLight = Color(0xFFC8A8A8)
private val onSecondaryLight = Color(0xFF382B2B)
private val secondaryContainerLight = Color(0xFFF3E9E8)
private val onSecondaryContainerLight = Color(0xFF5D4B4B)

private val tertiaryLight = Color(0xFFB99A87)
private val onTertiaryLight = Color(0xFF30241D)
private val tertiaryContainerLight = Color(0xFFF5ECE7)
private val onTertiaryContainerLight = Color(0xFF59463B)

private val errorLight = Color(0xFFBA1A1A)
private val onErrorLight = Color(0xFFFFFFFF)
private val errorContainerLight = Color(0xFFFFDAD6)
private val onErrorContainerLight = Color(0xFF93000A)

private val backgroundLight = Color(0xFFFDFCFB)
private val onBackgroundLight = Color(0xFF514B49)

private val surfaceLight = Color(0xFFFFFFFF)
private val onSurfaceLight = Color(0xFF514B49)

private val surfaceVariantLight = Color(0xFFF2EDEB)
private val onSurfaceVariantLight = Color(0xFF8C7F7C)

private val outlineLight = Color(0xFFB6AAA7)
private val outlineVariantLight = Color(0xFFE8E0DE)

private val scrimLight = Color(0xFF000000)

private val inverseSurfaceLight = Color(0xFF383230)
private val inverseOnSurfaceLight = Color(0xFFF8F3F1)
private val inversePrimaryLight = Color(0xFFE7BDBD)

private val surfaceDimLight = Color(0xFFECE6E4)
private val surfaceBrightLight = Color(0xFFFFFFFF)

private val surfaceContainerLowestLight = Color(0xFFFFFFFF)
private val surfaceContainerLowLight = Color(0xFFFAF8F7)
private val surfaceContainerLight = Color(0xFFF6F3F2)
private val surfaceContainerHighLight = Color(0xFFF0EBE9)
private val surfaceContainerHighestLight = Color(0xFFEAE3E1)
//endregion

//region Warm Home Dark Colors (placeholder - to be designed later)
private val primaryDark = Color(0xFFE7BDBD)
private val onPrimaryDark = Color(0xFF3E2222)
private val primaryContainerDark = Color(0xFF5A3838)
private val onPrimaryContainerDark = Color(0xFFF7E8E6)

private val secondaryDark = Color(0xFFD5BBBB)
private val onSecondaryDark = Color(0xFF2E2222)
private val secondaryContainerDark = Color(0xFF4A3838)
private val onSecondaryContainerDark = Color(0xFFF3E9E8)

private val tertiaryDark = Color(0xFFD4B9A5)
private val onTertiaryDark = Color(0xFF2A1F18)
private val tertiaryContainerDark = Color(0xFF4D3B30)
private val onTertiaryContainerDark = Color(0xFFF5ECE7)

private val errorDark = Color(0xFFFFB4AB)
private val onErrorDark = Color(0xFF690005)
private val errorContainerDark = Color(0xFF93000A)
private val onErrorContainerDark = Color(0xFFFFDAD6)

private val backgroundDark = Color(0xFF1A1716)
private val onBackgroundDark = Color(0xFFEAE3E1)

private val surfaceDark = Color(0xFF1A1716)
private val onSurfaceDark = Color(0xFFEAE3E1)

private val surfaceVariantDark = Color(0xFF4A4241)
private val onSurfaceVariantDark = Color(0xFFD0C6C4)

private val outlineDark = Color(0xFF998E8C)
private val outlineVariantDark = Color(0xFF4A4241)

private val scrimDark = Color(0xFF000000)

private val inverseSurfaceDark = Color(0xFFEAE3E1)
private val inverseOnSurfaceDark = Color(0xFF383230)
private val inversePrimaryDark = Color(0xFFD9A3A3)

private val surfaceDimDark = Color(0xFF1A1716)
private val surfaceBrightDark = Color(0xFF413A38)

private val surfaceContainerLowestDark = Color(0xFF140F0E)
private val surfaceContainerLowDark = Color(0xFF231E1D)
private val surfaceContainerDark = Color(0xFF272221)
private val surfaceContainerHighDark = Color(0xFF322C2B)
private val surfaceContainerHighestDark = Color(0xFF3D3635)
//endregion

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)
