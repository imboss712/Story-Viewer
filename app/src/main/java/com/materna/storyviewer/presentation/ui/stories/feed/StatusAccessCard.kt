package com.materna.storyviewer.presentation.ui.stories.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.materna.storyviewer.presentation.components.PrimaryButton
import com.materna.storyviewer.presentation.theme.StoryViewerIcon
import com.materna.storyviewer.presentation.theme.StoryViewerTheme

@Composable
fun StatusAccessCard(
    onAllowAccessClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        StatusAccessCardHeader()
        StatusAccessCardContent()
        StatusAccessCardFooter(
            onAllowAccessClick = onAllowAccessClick
        )
    }
}

@Composable
private fun StatusAccessCardHeader(
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
                painter = painterResource(StoryViewerIcon.Folder),
                contentDescription = null,
                tint = StoryViewerTheme.colorScheme.primaryColor,
                modifier = Modifier.size(48.dp)
            )
        }

        Text(
            text = "Allow Access to Statuses",
            style = StoryViewerTheme.typography.title.copy(
                fontSize = 24.sp
            ),
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )
    }
}

@Composable
private fun StatusAccessCardContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "To display the statuses, Story Viewer needs access to your files.",
            style = StoryViewerTheme.typography.body,
            color = StoryViewerTheme.colorScheme.onBackgroundColor,
            modifier = modifier
        )
        Text(
            text = "Please proceed to allow access to the specified folder and click on Use this folder.",
            style = StoryViewerTheme.typography.body,
            color = StoryViewerTheme.colorScheme.onBackgroundColor,
            modifier = modifier
        )
    }
}

@Composable
private fun StatusAccessCardFooter(
    onAllowAccessClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    PrimaryButton(
        label = "Allow access",
        onClick = onAllowAccessClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Preview
@Composable
private fun StatusAccessCardPreview() {
    StoryViewerTheme(darkTheme = true) {
        StatusAccessCard(
            onAllowAccessClick = {},
            modifier = Modifier
                .background(color = StoryViewerTheme.colorScheme.backgroundColor)
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
        )
    }
}
