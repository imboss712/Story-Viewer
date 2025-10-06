package com.materna.storyviewer.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.materna.storyviewer.presentation.navigation.StoryViewerNavHost
import com.materna.storyviewer.presentation.theme.StoryViewerTheme

@Composable
fun StoryViewerApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // The top app bar is part of the screen layout,
    // so the content's window insets are zero on all sides.
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = StoryViewerTheme.colorScheme.backgroundColor,
        contentColor = StoryViewerTheme.colorScheme.onBackgroundColor
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            StoryViewerNavHost(
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun StoryViewerAppPreview() {
    StoryViewerTheme {
        StoryViewerApp()
    }
}

