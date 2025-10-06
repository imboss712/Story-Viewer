package com.materna.storyviewer.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Graph {
    @Serializable
    data object Auth : Graph

    @Serializable
    data object Main : Graph

    @Serializable
    data object Viewer : Graph

    @Serializable
    data object Settings : Graph
}

sealed interface Route {
    @Serializable
    data object DisclaimerScreen : Route

    @Serializable
    data object StoriesFeedScreen : Route

    @Serializable
    data object SavedStoriesScreen : Route

    @Serializable
    data object StoryImageScreen : Route

    @Serializable
    data object StoryVideoScreen : Route

    @Serializable
    data object SettingsHomeScreen : Route

    @Serializable
    data object AppearanceSettingsScreen : Route

    @Serializable
    data object StorageSettingsScreen : Route

    @Serializable
    data object HelpScreen : Route

    @Serializable
    data object AboutScreen : Route

    @Serializable
    data object PrivacyScreen : Route
}
