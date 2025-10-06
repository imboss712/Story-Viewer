package com.materna.storyviewer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.materna.storyviewer.presentation.theme.StoryViewerTheme
import com.materna.storyviewer.presentation.ui.StoryViewerApp
import com.materna.storyviewer.presentation.util.isSystemInDarkTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var darkTheme by mutableStateOf(resources.configuration.isSystemInDarkTheme)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { handleThemeChanges { darkTheme = it } }
            }
        }

        splashScreen.setKeepOnScreenCondition { viewModel.showSplashScreen.value }

        setContent {
            StoryViewerTheme(darkTheme = darkTheme) {
                applyEdgeToEdge(darkTheme)

                StoryViewerApp()
            }
        }
    }

    private suspend fun handleThemeChanges(onThemeChange: (Boolean) -> Unit) {
        isSystemInDarkTheme()
            .distinctUntilChanged()
            .collect { isDarkTheme ->
                onThemeChange(isDarkTheme)
            }
    }

    private fun applyEdgeToEdge(isDarkTheme: Boolean) {
        val systemBarStyle = if (isDarkTheme) {
            SystemBarStyle.dark(Transparent_ARGB)
        } else {
            SystemBarStyle.light(Transparent_ARGB, Transparent_ARGB)
        }

        enableEdgeToEdge(statusBarStyle = systemBarStyle, navigationBarStyle = systemBarStyle)
    }

    companion object {
        val Transparent_ARGB = Color.Transparent.toArgb()
    }
}
