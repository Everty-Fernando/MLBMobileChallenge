package br.com.everty.product.presentation.product_list_result.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.card.ProductHorizontalCardSkeleton
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoaderRectangle
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductSearchResultsLoading() {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppSpacing.regular),
        modifier = Modifier.padding(AppSpacing.regular)
    ) {
        AppShimmerLoader { brush ->
            AppShimmerLoaderRectangle(
                modifier = Modifier
                    .padding(vertical = AppSpacing.regular)
                    .height(19.dp)
                    .fillMaxWidth(0.60f),
                brush = brush
            )
        }
        repeat(6) {
            ProductHorizontalCardSkeleton()
        }
    }
}

@Preview
@Composable
fun ProductSearchResultsLoadingPreview() {
    AppTheme {
        ProductSearchResultsLoading()
    }
}
