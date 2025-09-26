package com.materna.storyviewer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.materna.storyviewer.presentation.util.isSystemInDarkTheme
import com.materna.storyviewer.presentation.theme.StoryViewerTheme
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
            StoryViewerTheme {
                applyEdgeToEdge(darkTheme)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(StoryViewerTheme.colorScheme.backgroundColor)
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Greeting(name = "Android")
                    }
                }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = StoryViewerTheme.colorScheme.onBackgroundColor
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StoryViewerTheme {
        Greeting("Android")
    }
}