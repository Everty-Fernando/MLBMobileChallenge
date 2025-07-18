package br.com.everty.product.presentation.product_list_result.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.presentation.product_list_result.components.ProductSearchResultsContent
import br.com.everty.product.presentation.product_list_result.components.ProductSearchResultsHeader
import br.com.everty.product.presentation.product_list_result.components.ProductSearchResultsLoading
import br.com.everty.product.presentation.product_list_result.events.ProductResultEvents
import br.com.everty.product.presentation.product_search.preview.productUIStatePreview
import br.com.everty.product.presentation.product_search.state.ProductUIState
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import androidx.compose.material3.MaterialTheme
import br.com.everty.shared.presentation.design_system.components.AppScaffold

@Composable
fun ProductSearchResultsScreen(
    state: ProductUIState,
    events: ProductResultEvents,
) {
    AppScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        ProductSearchResultsScreenContent(
            state = state,
            onValueChangeSearch = events::onValueChangeSearch,
            onBackClick = events::onBackClick,
            onSearchClick = events::onSearchClick
        )
    }
}

@Composable
fun ProductSearchResultsScreenContent(
    state: ProductUIState,
    onValueChangeSearch: (String) -> Unit,
    onSearchClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ProductSearchResultsHeader(
            query = state.inputQuery,
            onQueryChange = onValueChangeSearch,
            onBackClick = onBackClick,
            onSearchClick = { onSearchClick(state.inputQuery) }
        )

        if (state.isLoading) {
            ProductSearchResultsLoading()
        } else {
            ProductSearchResultsContent(
                query = state.inputQuery,
                productList = state.productList
            )
        }
    }
}

@Preview
@Composable
private fun ProductSearchResultScreenPreview() {
    AppTheme {
        ProductSearchResultsScreenContent(
            state = productUIStatePreview,
            onValueChangeSearch = {},
            onSearchClick = {},
            onBackClick = {}
        )
    }
}

