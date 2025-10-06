package com.materna.storyviewer.presentation.navigation

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.materna.storyviewer.presentation.theme.StoryViewerTheme
import com.materna.storyviewer.presentation.ui.auth.DisclaimerScreen

@Composable
fun StoryViewerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // TODO(shashi): preference to update startDestination if user has read the disclaimer
    val startDestination = Graph.Auth

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(navController)
        mainGraph(navController)
        viewerGraph(navController)
        settingsGraph(navController)
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation<Graph.Auth>(
        startDestination = Route.DisclaimerScreen
    ) {
        composable<Route.DisclaimerScreen> {
            val activity = LocalActivity.current

            DisclaimerScreen(
                onBackClick = { activity?.finish() },
                onUnderstandClick = { navController.navigate(Route.StoriesFeedScreen) }
            )
        }
    }
}

fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation<Graph.Main>(
        startDestination = Route.StoriesFeedScreen
    ) {
        composable<Route.StoriesFeedScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Stories Feed screen")
            }
        }

        composable<Route.SavedStoriesScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Saved Stories screen")
            }
        }
    }
}

fun NavGraphBuilder.viewerGraph(navController: NavController) {
    navigation<Graph.Viewer>(
        startDestination = Route.StoryImageScreen
    ) {
        // TODO(shashi): create an empty composable to navigate to appropriate route based on story type.
        composable<Route.StoryImageScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Image Viewer screen")
            }
        }

        composable<Route.StoryVideoScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Video Player screen")
            }
        }
    }
}

fun NavGraphBuilder.settingsGraph(navController: NavController) {
    navigation<Graph.Settings>(
        startDestination = Route.SettingsHomeScreen
    ) {
        composable<Route.SettingsHomeScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Settings screen")
            }
        }

        composable<Route.AppearanceSettingsScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Appearance screen")
            }
        }

        composable<Route.StorageSettingsScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Storage screen")
            }
        }

        composable<Route.PrivacyScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Privacy screen")
            }
        }

        composable<Route.HelpScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Help screen")
            }
        }

        composable<Route.AboutScreen> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StoryViewerTheme.colorScheme.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "About screen")
            }
        }
    }
}
