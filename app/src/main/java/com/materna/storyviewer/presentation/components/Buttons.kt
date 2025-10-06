package com.materna.storyviewer.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.materna.storyviewer.presentation.theme.StoryViewerTheme

@Composable
fun PrimaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = StoryViewerTheme.colorScheme.primaryColor,
        contentColor = StoryViewerTheme.colorScheme.onPrimaryColor
    )
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = label,
            style = StoryViewerTheme.typography.body.copy(
                fontSize = 18.sp
            ),
            color = StoryViewerTheme.colorScheme.onPrimaryColor
        )
    }
}

@Composable
fun SecondaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        containerColor = StoryViewerTheme.colorScheme.backgroundColor,
        contentColor = StoryViewerTheme.colorScheme.primaryColor
    )
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = colors,
        border = BorderStroke(
            width = 1.5.dp,
            color = StoryViewerTheme.colorScheme.primaryBorderColor
        )
    ) {
        Text(
            text = label,
            style = StoryViewerTheme.typography.body.copy(
                fontSize = 18.sp
            ),
            color = StoryViewerTheme.colorScheme.primaryColor
        )
    }
}

@Composable
fun TextButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        containerColor = StoryViewerTheme.colorScheme.surfaceColor,
        contentColor = StoryViewerTheme.colorScheme.primaryColor
    )
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = colors
    ) {
        Text(
            text = label,
            style = StoryViewerTheme.typography.body.copy(
                fontSize = 18.sp
            ),
            color = StoryViewerTheme.colorScheme.primaryColor
        )
    }
}
