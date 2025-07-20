package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductDetailsSellerInfo(
    sellerName: String,
    stockAvailable: Int
) {
    Column(
        modifier = Modifier.padding(horizontal = AppSpacing.base)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacing.mini)
        ) {
            Text(
                text = stringResource(R.string.product_details_sold_by),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AppTheme.colors.secondaryText
                )
            )
            
            Text(
                text = sellerName,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AppTheme.colors.primary,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        
        Spacer(modifier = Modifier.height(AppSpacing.mini))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.product_details_avaliable_stock),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AppTheme.colors.secondaryText
                )
            )

            Text(
                text = stringResource(R.string.product_details_un, stockAvailable),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AppTheme.colors.onBackground,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Preview
@Composable
fun ProductDetailsSellerInfoPreview() {
    ProductDetailsSellerInfo(
        sellerName = "TechStore Oficial",
        stockAvailable = 15
    )
}
