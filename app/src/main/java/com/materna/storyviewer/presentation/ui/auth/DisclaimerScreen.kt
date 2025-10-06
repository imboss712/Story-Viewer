package com.materna.storyviewer.presentation.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.materna.storyviewer.presentation.components.PrimaryButton
import com.materna.storyviewer.presentation.components.TextButton
import com.materna.storyviewer.presentation.theme.StoryViewerIcon
import com.materna.storyviewer.presentation.theme.StoryViewerTheme

@Composable
fun DisclaimerScreen(
    onBackClick: () -> Unit,
    onUnderstandClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = StoryViewerTheme.colorScheme.backgroundColor)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        DisclaimerContent(
            onBackClick = onBackClick,
            onUnderstandClick = onUnderstandClick,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 20.dp
            )
        )
    }
}

@Composable
private fun DisclaimerContent(
    onBackClick: () -> Unit,
    onUnderstandClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            DisclaimerHeader()
            DisclaimerMessage()
        }

        DisclaimerFooter(
            onBackClick = onBackClick,
            onUnderstandClick = onUnderstandClick
        )
    }
}

@Composable
private fun DisclaimerHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = modifier
                .size(112.dp)
                .clip(CircleShape)
                .background(StoryViewerTheme.colorScheme.surfaceColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(StoryViewerIcon.Warning),
                contentDescription = null,
                tint = StoryViewerTheme.colorScheme.primaryColor,
                modifier = Modifier.size(64.dp)
            )
        }

        Text(
            text = "Disclaimer",
            style = StoryViewerTheme.typography.title.copy(
                fontSize = 32.sp
            ),
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )
    }
}

@Composable
private fun DisclaimerMessage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Status Viewer is an independent app and is not officially associated with, affiliated, endorsed, or sponsored by any social media platforms.",
            style = StoryViewerTheme.typography.body,
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )

        Text(
            text = "This app only displays content from your device's cached storage. You are responsible for respecting copyright and using content appropriately.",
            style = StoryViewerTheme.typography.body,
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )

        Text(
            text = "No content is stored on our servers. everything is saved locally on your device.",
            style = StoryViewerTheme.typography.body,
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )
    }
}

@Composable
private fun DisclaimerFooter(
    onBackClick: () -> Unit,
    onUnderstandClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PrimaryButton(
            label = "I understand",
            onClick = onUnderstandClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        TextButton(
            label = "Go back",
            onClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun DisclaimerScreenPreview() {
    StoryViewerTheme(darkTheme = false) {
        DisclaimerScreen(
            onBackClick = {},
            onUnderstandClick = {}
        )
    }
}
