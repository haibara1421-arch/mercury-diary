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
        // Sidebar background
        assertEquals(Color(0xFFFCFBFC), colors.sidebar.background)
        assertEquals(Color(0xFFFAF0F1), colors.sidebar.selectedBackground)
        // Level-1 navigation
        assertEquals(Color(0xFF514247), colors.sidebar.primaryNormalText)
        assertEquals(Color(0xFFA16D7E), colors.sidebar.primarySelectedText)
        assertEquals(Color(0xFF81797B), colors.sidebar.primaryNormalIcon)
        assertEquals(Color(0xFFA16D7E), colors.sidebar.primarySelectedIcon)
        // Level-2 navigation
        assertEquals(Color(0xFF5D5357), colors.sidebar.secondaryNormalText)
        assertEquals(Color(0xFFA77585), colors.sidebar.secondarySelectedText)
        // Chevron
        assertEquals(Color(0xFF91898B), colors.sidebar.chevronColor)
        // User profile
        assertEquals(Color(0xFF514247), colors.sidebar.nicknameColor)
        assertEquals(Color(0xFF91898B), colors.sidebar.greetingColor)
        // Role list
        assertEquals(Color(0xFFFCFBFC), colors.roles.listBackground)
        assertEquals(Color(0xFFFAF0F1), colors.roles.selectedBackground)
        assertEquals(Color(0xFF514247), colors.roles.nameContent)
        assertEquals(Color(0xFFAC7181), colors.roles.addIcon)
    }
}
