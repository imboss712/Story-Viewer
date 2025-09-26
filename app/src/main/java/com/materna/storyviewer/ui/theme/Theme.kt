package com.materna.storyviewer.ui.theme

import android.app.Activity
import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

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

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            updateSystemBarsAppearance(window, darkTheme)
        }
    }

    CompositionLocalProvider(
        LocalStoryViewerColors provides colorScheme,
        LocalStoryViewerType provides typography
    ) {
        MaterialTheme {
            content()
        }
    }
}

private fun updateSystemBarsAppearance(window: Window, darkTheme: Boolean) {
    val insetsController = WindowCompat.getInsetsController(window, window.decorView)
    insetsController.isAppearanceLightStatusBars = !darkTheme
    insetsController.isAppearanceLightNavigationBars = !darkTheme
}

object StoryViewerTheme {
    val colorScheme: StoryViewerColorScheme
        @Composable
        get() = LocalStoryViewerColors.current

    val typography: StoryViewerTypography
        @Composable
        get() = LocalStoryViewerType.current
}
