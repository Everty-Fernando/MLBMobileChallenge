package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing

@Composable
fun ProductDetailsSellerInfo(
    sellerName: String,
    stockAvailable: Int
) {
    Column(modifier = Modifier.padding(horizontal = AppSpacing.regular)) {
        Text(
            text = "Vendido por $sellerName",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Estoque disponível: $stockAvailable unidades",
            style = MaterialTheme.typography.bodyMedium
        )
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
