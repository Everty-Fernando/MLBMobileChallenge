package br.com.everty.shared.presentation.design_system.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppBadgeLabel(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colors.success.copy(alpha = 0.2f),
    contentColor: Color = AppTheme.colors.success,
    textStyle: TextStyle = MaterialTheme.typography.labelSmall
) {
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.extraLarge
            )
            .padding(horizontal = AppSpacing.mini, vertical = AppSpacing.micro)
    ) {
        Text(
            text = text,
            color = contentColor,
            style = textStyle,
            maxLines = 1
        )
    }
}

@Preview
@Composable
private fun AppBadgeLabelPreview() {
    AppTheme {
        AppBadgeLabel(text = "Novo")
    }
}

