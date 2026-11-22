package me.rerere.rikkahub.ui.theme.mercury

import me.rerere.rikkahub.ui.theme.PresetTheme
import me.rerere.rikkahub.ui.theme.mercury.presets.MorningRoseTheme

/** Separate registry: classic presets and user-created themes stay untouched. */
data class MercuryTheme(
    val preset: PresetTheme,
    val lightColors: MercuryThemeColors,
    val darkColors: MercuryThemeColors,
) {
    val id: String get() = preset.id

    fun getColors(dark: Boolean): MercuryThemeColors =
        if (dark) darkColors else lightColors
}

val MercuryThemes: List<MercuryTheme> by lazy { listOf(MorningRoseTheme) }

fun findMercuryTheme(id: String): MercuryTheme? =
    MercuryThemes.firstOrNull { it.id == id }
