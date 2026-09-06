package com.clockapp.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF35618E),
    secondary = Color(0xFF54606E),
    background = Color(0xFFFAFCFF),
    surface = Color(0xFFFAFCFF)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFA1C9FF),
    secondary = Color(0xFFBBC7D8),
    background = Color(0xFF10131A),
    surface = Color(0xFF10131A)
)

@Composable
fun ClockAppTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
