package com.materna.storyviewer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalStoryViewerColors = staticCompositionLocalOf {
    LightColorScheme
}

private val LocalStoryViewerType = staticCompositionLocalOf {
    Typography
}

@Composable
fun StoryViewerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val typography = Typography

    CompositionLocalProvider(
        LocalStoryViewerColors provides colorScheme,
        LocalStoryViewerType provides typography
    ) {
        MaterialTheme {
            content()
        }
    }
}

object StoryViewerTheme {
    val colorScheme: StoryViewerColorScheme
        @Composable
        get() = LocalStoryViewerColors.current

    val typography: StoryViewerTypography
        @Composable
        get() = LocalStoryViewerType.current
}
