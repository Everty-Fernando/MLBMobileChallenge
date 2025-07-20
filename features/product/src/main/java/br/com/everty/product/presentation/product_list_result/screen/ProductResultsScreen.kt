package br.com.everty.product.presentation.product_list_result.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.product.presentation.product_list_result.components.ProductResultsContent
import br.com.everty.product.presentation.product_list_result.components.ProductResultsHeader
import br.com.everty.product.presentation.product_list_result.components.ProductResultsLoading
import br.com.everty.product.presentation.product_list_result.events.ProductResultEvents
import br.com.everty.product.presentation.product_list_result.preview.productResultsUIStatePreview
import br.com.everty.product.presentation.product_list_result.state.ProductResultsUIState
import br.com.everty.shared.presentation.design_system.components.AppScaffold
import br.com.everty.shared.presentation.design_system.components.feedback.AppEmptyState
import br.com.everty.shared.presentation.design_system.components.feedback.AppErrorState
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductResultsScreen(
    state: ProductResultsUIState,
    events: ProductResultEvents,
) {
    AppScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        ProductResultsScreenContent(
            state = state,
            onValueChangeSearch = events::onValueChangeSearch,
            onBackClick = events::onBackClick,
            onSearchClick = events::onSearchClick,
            onProductDetailsClick = events::onProductDetailsClick,
            onRetry = events::onRetry
        )
    }
}

@Composable
fun ProductResultsScreenContent(
    state: ProductResultsUIState,
    onValueChangeSearch: (String) -> Unit,
    onSearchClick: (String) -> Unit,
    onProductDetailsClick: (String) -> Unit,
    onBackClick: () -> Unit,
    onRetry: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ProductResultsHeader(
            query = state.inputQuery,
            onQueryChange = onValueChangeSearch,
            onBackClick = onBackClick,
            onSearchClick = { onSearchClick(state.inputQuery) }
        )
        when {
            state.isLoading -> {
                ProductResultsLoading()
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
                ProductResultsContent(
                    query = state.searchedText,
                    productList = state.productList,
                    onProductClick = onProductDetailsClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductResultScreenPreview() {
    AppTheme {
        ProductResultsScreenContent(
            state = productResultsUIStatePreview,
            onValueChangeSearch = {},
            onSearchClick = {},
            onBackClick = {},
            onProductDetailsClick = {},
            onRetry = {}
        )
    }
}

