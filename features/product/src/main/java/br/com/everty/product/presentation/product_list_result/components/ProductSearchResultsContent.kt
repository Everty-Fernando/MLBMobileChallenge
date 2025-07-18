package br.com.everty.product.presentation.product_list_result.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.shared.presentation.design_system.components.card.ProductHorizontalCard
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.product.presentation.product_list_result.preview.productsPreview
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductSearchResultsContent(
    query: String,
    productList: List<ProductModelUI>
) {

    LazyColumn(
        contentPadding = PaddingValues(AppSpacing.regular),
        verticalArrangement = Arrangement.spacedBy(AppDimens.xSmall),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = stringResource(
                    R.string.product_search_results_label,
                    productList.size,
                    query
                ),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(AppSpacing.regular)
            )
            Spacer(modifier = Modifier.height(AppDimens.xSmall))
        }

        items(productList) { product ->
            ProductHorizontalCard(
                imageUrl = product.imageUrl,
                title = product.title,
                rating = product.rating ?: 0f,
                reviewCount = product.ratingCount ?: 0,
                priceOriginal = product.originalPrice,
                pricePromotional = product.currentPrice,
                hasFreeShipping = product.hasFreeShipping,
            )
        }
    }
}

@Preview
@Composable
fun ProductSearchResultsContentPreview() {
    AppTheme {
        ProductSearchResultsContent(
            query = "teste",
            productList = productsPreview
        )
    }
}