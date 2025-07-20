package br.com.everty.product.presentation.product_search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.presentation.product_search.preview.productsHighlightsPreview
import br.com.everty.shared.presentation.design_system.components.card.ProductCard
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductSearchContent(
    products: List<ProductModelUI>,
    onProductClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = AppSpacing.regular,
            vertical = AppSpacing.regular
        ),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.small),
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.small)
    ) {
        item(span = { GridItemSpan(2) }) {
            Text(
                text = stringResource(R.string.product_search_title_highlights),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = AppSpacing.small)
            )
        }

        items(products) { product ->
            ProductCard(
                imageUrl = product.imageUrl,
                title = product.title,
                currentPrice = product.currentPrice,
                originalPrice = product.originalPrice,
                onProductClick = { onProductClick(product.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSearchContentPreview() {
    AppTheme {
        ProductSearchContent(
            products = productsHighlightsPreview,
            onProductClick = {}
        )
    }
}
