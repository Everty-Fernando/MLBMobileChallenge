package br.com.everty.product.presentation.product_search.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.product.presentation.product_search.components.ProductListLoadingContent
import br.com.everty.product.presentation.product_search.components.ProductSearchContent
import br.com.everty.product.presentation.product_search.components.ProductSearchHeader
import br.com.everty.product.presentation.product_search.events.ProductSearchEvents
import br.com.everty.product.presentation.product_search.preview.productUIStatePreview
import br.com.everty.product.presentation.product_search.state.ProductUIState
import br.com.everty.shared.presentation.design_system.components.AppScaffold
import br.com.everty.shared.presentation.design_system.components.feedback.AppEmptyState
import br.com.everty.shared.presentation.design_system.components.feedback.AppErrorState
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductSearchScreen(
    state: ProductUIState,
    events: ProductSearchEvents,
) {
    AppScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        ProductSearchScreenContent(
            state = state,
            onValueChangeSearch = events::onValueChangeSearch,
            onSearchClick = events::onSearchClick,
            onProductDetailsClick = events::onProductDetailsClick,
            onRetry = events::onRetry,
            onSearchIconClick = events::onSearchIconClick,
            onCloseSearch = events::onCloseSearch
        )
    }
}

@Composable
fun ProductSearchScreenContent(
    state: ProductUIState,
    onValueChangeSearch: (String) -> Unit,
    onSearchClick: (String) -> Unit,
    onProductDetailsClick: (String) -> Unit,
    onRetry: () -> Unit,
    onSearchIconClick: () -> Unit,
    onCloseSearch: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ProductSearchHeader(
            query = state.inputQuery,
            isSearching = state.isSearching,
            onQueryChange = onValueChangeSearch,
            onSearchClick = { onSearchClick(state.inputQuery) },
            onSearchIconClick = onSearchIconClick,
            onCloseSearch = onCloseSearch
        )

        when {
            state.isLoading -> {
                ProductListLoadingContent()
            }
            state.errorMessage.isNotEmpty() -> {
                AppErrorState(
                    code = state.errorCode,
                    message = state.errorMessage,
                    showRetry = state.showRetry,
                    onRetry = onRetry
                )
            }
            state.productList.isEmpty() -> {
                AppEmptyState(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    message = stringResource(R.string.product_empty_state),
                    lottieAsset = "empty_state.json",
                )
            }
            else -> {
                ProductSearchContent(
                    products = state.productList,
                    onProductClick = onProductDetailsClick
                )
            }
        }
    }
}

@Composable
@Preview
private fun ProductSearchScreenContent_Giro_Preview() {
    AppTheme {
        ProductSearchScreenContent(
            state = productUIStatePreview,
            onValueChangeSearch = {},
            onSearchClick = {},
            onProductDetailsClick = {},
            onRetry = {},
            onSearchIconClick = {},
            onCloseSearch = {},
        )
    }
}