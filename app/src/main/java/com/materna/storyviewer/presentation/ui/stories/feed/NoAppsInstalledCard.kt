package com.materna.storyviewer.presentation.ui.stories.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.materna.storyviewer.presentation.theme.StoryViewerIcon
import com.materna.storyviewer.presentation.theme.StoryViewerTheme

@Composable
fun NoAppsInstalledCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        NoAppsInstalledHeader()
        NoAppsInstalledContent()
    }
}

@Composable
private fun NoAppsInstalledHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(StoryViewerTheme.colorScheme.surfaceColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(StoryViewerIcon.Apps),
                contentDescription = null,
                tint = StoryViewerTheme.colorScheme.primaryColor,
                modifier = Modifier.size(48.dp)
            )
        }

        Text(
            text = "No Apps Installed",
            style = StoryViewerTheme.typography.title.copy(
                fontSize = 24.sp
            ),
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )
    }
}

@Composable
private fun NoAppsInstalledContent(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Please install WhatsApp and/or WhatsApp Business apps to see your friend statuses here.",
        style = StoryViewerTheme.typography.body,
        color = StoryViewerTheme.colorScheme.onBackgroundColor,
        modifier = modifier
    )
}

@Preview
@Composable
private fun NoAppsInstalledPreview() {
    StoryViewerTheme(darkTheme = true) {
        NoAppsInstalledCard(
            modifier = Modifier
                .background(color = StoryViewerTheme.colorScheme.backgroundColor)
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
        )
    }
}
