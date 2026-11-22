package me.rerere.rikkahub.ui.theme.mercury

import androidx.compose.ui.graphics.Color
import me.rerere.rikkahub.ui.theme.PresetThemes
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class MercuryThemesTest {
    @Test
    fun `mercury IDs do not collide with classic themes`() {
        val classicIds = PresetThemes.map { it.id }.toSet()
        val mercuryIds = MercuryThemes.map { it.id }
        assertEquals(mercuryIds.size, mercuryIds.distinct().size)
        assertFalse(mercuryIds.any { it in classicIds })
        assertNull(findMercuryTheme("sakura"))
        assertNotNull(findMercuryTheme("mercury.morning_rose"))
    }

    @Test
    fun `approved morning rose sidebar colors are preserved`() {
        val colors = requireNotNull(findMercuryTheme("mercury.morning_rose")).lightColors
        assertEquals(Color(0xFFFCFBFC), colors.sidebar.background)
        assertEquals(Color(0xFFFAF0F1), colors.sidebar.navigationSelectedBackground)
        assertEquals(Color(0xFF5D5357), colors.sidebar.navigationNormalContent)
        assertEquals(Color(0xFFA77585), colors.sidebar.navigationSelectedContent)
        assertEquals(Color(0xFFFCFBFC), colors.roles.listBackground)
        assertEquals(Color(0xFFFAF0F1), colors.roles.selectedBackground)
        assertEquals(Color(0xFF514247), colors.roles.nameContent)
        assertEquals(Color(0xFFAC7181), colors.roles.addIcon)
    }
}
