package br.com.everty.shared.presentation.design_system.components.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing

@Composable
fun AppTextWithIcon(
    icon: ImageVector,
    iconTint: Color = AppTheme.colors.primary,
    text: String,
    textColor: Color = AppTheme.colors.onBackground,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(AppDimens.small)
        )
        Spacer(modifier = Modifier.width(AppSpacing.mini))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(color = textColor)
        )
    }
}

@Preview
@Composable
private fun AppTextWithIconPreview() {
    AppTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AppTextWithIcon(
                icon = Icons.Default.ShoppingCart,
                iconTint = AppTheme.colors.success,
                text = "Chega grátis amanhã"
            )
            AppTextWithIcon(
                icon = Icons.Default.ShoppingCart,
                iconTint = AppTheme.colors.success,
                text = "Pague em até 12x sem juros"
            )
            AppTextWithIcon(
                icon = Icons.Default.ShoppingCart,
                iconTint = AppTheme.colors.success,
                text = "Garantia oficial de 1 ano"
            )
        }
    }
}
