package br.com.everty.shared.presentation.design_system.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppActionButton(
    text: String,
    modifier: Modifier = Modifier,
    isPrimary: Boolean = true,
    onClick: () -> Unit
) {
    val backgroundColor = if (isPrimary) AppTheme.colors.highlight else AppTheme.colors.background
    val border = if (isPrimary) null else BorderStroke(AppDimens.tiny, AppTheme.colors.highlight)

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = AppTheme.colors.primary
        ),
        border = border,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Preview
@Composable
private fun AppActionButtonPrimaryPreview() {
    AppTheme {
        AppActionButton(
            text = "Comprar",
            isPrimary = true,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun AppActionButtonSecondaryPreview() {
    AppTheme {
        AppActionButton(
            text = "Adicionar ao carrinho",
            isPrimary = false,
            onClick = {}
        )
    }
}
