package com.materna.storyviewer.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

// TODO(shashi): colors are AI generated, and subject to change.
val LightColorScheme = StoryViewerColorScheme(
    primaryColor = Color(0xFF1DB954),
    onPrimaryColor = Color(0xFFFFFFFF),
    primaryBorderColor = Color(0xFF12813A),
    secondaryColor = Color(0xFFE0E0E0),
    onSecondaryColor = Color(0xFF000000),
    secondaryBorderColor = Color(0xFFBDBDBD),
    backgroundColor = Color(0xFFFFFFFF),
    onBackgroundColor = Color(0xFF212121),
    surfaceColor = Color(0xFFF5F5F5),
    onSurfaceColor = Color(0xFF212121),
    errorColor = Color(0xFFD32F2F),
    errorBackgroundColor = Color(0x1FD32F2F),
    successColor = Color(0xFF388E3C),
    successBackgroundColor = Color(0x1F388E3C),
    warningColor = Color(0xFFFFA000),
    warningBackgroundColor = Color(0x1FFFFA00),
    infoColor = Color(0xFF1976D2),
    infoBackgroundColor = Color(0x1F1976D2),
    textColor = Color(0xFF212121),
    outlineColor = Color(0xFFBDBDBD),
    hintColor = Color(0xFF9E9E9E),
    dividerColor = Color(0xFFE0E0E0),
    highlightColor = Color(0xFF43A047),
    shadowColor = Color(0x1A000000),
    overlayColor = Color(0x0D000000),
    rippleColor = Color(0x22000000)
)

val DarkColorScheme = StoryViewerColorScheme(
    primaryColor = Color(0xFF1DB954),
    onPrimaryColor = Color(0xFFFFFFFF),
    primaryBorderColor = Color(0xFF12813A),
    secondaryColor = Color(0xFF2E2E2E),
    onSecondaryColor = Color(0xFFE0E0E0),
    secondaryBorderColor = Color(0xFF3A3A3A),
    backgroundColor = Color(0xFF191919),
    onBackgroundColor = Color(0xFFE0E0E0),
    surfaceColor = Color(0xFF222222),
    onSurfaceColor = Color(0xFFE0E0E0),
    errorColor = Color(0xFFCF6679),
    errorBackgroundColor = Color(0x40CF6679),
    successColor = Color(0xFF00C853),
    successBackgroundColor = Color(0x4000C853),
    warningColor = Color(0xFFFFAB00),
    warningBackgroundColor = Color(0x40FFAB00),
    infoColor = Color(0xFF2196F3),
    infoBackgroundColor = Color(0x402196F3),
    textColor = Color(0xFFE0E0E0),
    outlineColor = Color(0xFF444444),
    hintColor = Color(0xFF888888),
    dividerColor = Color(0xFF2C2C2C),
    highlightColor = Color(0xFF2E7D32),
    shadowColor = Color(0x80000000),
    overlayColor = Color(0x66000000),
    rippleColor = Color(0x33FFFFFF)
)

@Immutable
data class StoryViewerColorScheme(
    val primaryColor: Color,
    val onPrimaryColor: Color,
    val primaryBorderColor: Color,
    val secondaryColor: Color,
    val onSecondaryColor: Color,
    val secondaryBorderColor: Color,
    val backgroundColor: Color,
    val onBackgroundColor: Color,
    val surfaceColor: Color,
    val onSurfaceColor: Color,
    val errorColor: Color,
    val errorBackgroundColor: Color,
    val successColor: Color,
    val successBackgroundColor: Color,
    val warningColor: Color,
    val warningBackgroundColor: Color,
    val infoColor: Color,
    val infoBackgroundColor: Color,
    val textColor: Color,
    val outlineColor: Color,
    val hintColor: Color,
    val dividerColor: Color,
    val highlightColor: Color,
    val shadowColor: Color,
    val overlayColor: Color,
    val rippleColor: Color
)
