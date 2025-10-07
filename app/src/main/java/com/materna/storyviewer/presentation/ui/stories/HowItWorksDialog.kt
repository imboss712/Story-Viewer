package com.materna.storyviewer.presentation.ui.stories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.materna.storyviewer.presentation.components.PrimaryButton
import com.materna.storyviewer.presentation.theme.StoryViewerIcon
import com.materna.storyviewer.presentation.theme.StoryViewerTheme

@Composable
fun HowItWorksDialog(
    onDismiss: () -> Unit,
    onGotItClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(24.dp))
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            HowItWorksDialogHeader()
            HowItWorksContent()
            HowItWorksProTip()
            HowItWorksDialogFooter(
                onGotItClick = {
                    onGotItClick()
                    onDismiss()
                }
            )
        }
    }
}

@Composable
private fun HowItWorksDialogHeader(
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
                painter = painterResource(StoryViewerIcon.Info),
                contentDescription = null,
                tint = StoryViewerTheme.colorScheme.primaryColor,
                modifier = Modifier.size(48.dp)
            )
        }

        Text(
            text = "How Story Saver Works",
            style = StoryViewerTheme.typography.title.copy(
                fontSize = 24.sp
            ),
            color = StoryViewerTheme.colorScheme.onBackgroundColor
        )
    }
}

@Composable
fun HowItWorksContent(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Story Saver fetches content from your device's cache. It's not linked with other social media apps.",
        style = StoryViewerTheme.typography.body,
        color = StoryViewerTheme.colorScheme.onBackgroundColor,
        modifier = modifier
    )
}

@Composable
private fun HowItWorksProTip(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(StoryViewerTheme.colorScheme.surfaceColor)
            .padding(
                horizontal = 16.dp,
                vertical = 20.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            painter = painterResource(StoryViewerIcon.LightBulb),
            contentDescription = "Pro Tip",
            tint = StoryViewerTheme.colorScheme.primaryColor,
            modifier = Modifier.size(24.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "Pro Tip",
                style = StoryViewerTheme.typography.bodyEmphasized,
                color = StoryViewerTheme.colorScheme.onBackgroundColor
            )

            Text(
                text = "If you are not seeing statuses, try watching them in the original app first to load them into the cache.",
                style = StoryViewerTheme.typography.label,
                color = StoryViewerTheme.colorScheme.onBackgroundColor
            )
        }
    }
}

@Composable
private fun HowItWorksDialogFooter(
    onGotItClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    PrimaryButton(
        label = "Got it",
        onClick = onGotItClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Preview
@Composable
private fun HowItWorksDialogPreview() {
    StoryViewerTheme(darkTheme = true) {
        HowItWorksDialog(
            onDismiss = {},
            onGotItClick = {},
            modifier = Modifier
                .background(color = StoryViewerTheme.colorScheme.backgroundColor)
        )
    }
}
