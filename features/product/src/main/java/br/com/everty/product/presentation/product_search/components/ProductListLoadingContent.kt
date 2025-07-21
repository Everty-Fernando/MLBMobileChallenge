package br.com.everty.product.presentation.product_search.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.card.ProductCardSkeleton
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoaderRectangle
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductListLoadingContent() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(AppSpacing.base),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.regular),
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.base),
        modifier = Modifier.fillMaxSize()
    ) {

        item(span = { GridItemSpan(2) }) {
            AppShimmerLoader { brush ->
                AppShimmerLoaderRectangle(
                    modifier = Modifier
                        .height(19.dp)
                        .fillMaxWidth(0.35f),
                    brush = brush
                )
            }
        }

        items(6) {
            ProductCardSkeleton()
        }
    }
}

@Preview
@Composable
private fun ProductListLoadingContentPreview() {
    AppTheme {
        ProductListLoadingContent()
    }
}