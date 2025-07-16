package br.com.everty.shared.presentation.design_system.components.logo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppLogo(
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    textSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    textColor: Color = MaterialTheme.colorScheme.onBackground
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Logo",
            tint = textColor,
            modifier = Modifier.size(iconSize)
        )

        Spacer(modifier = Modifier.width(AppSpacing.mini))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                    append("Mercado")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Buscar")
                }
            },
            fontSize = textSize,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun AppLogoPreview() {
    AppTheme {
        AppLogo()
    }
}

