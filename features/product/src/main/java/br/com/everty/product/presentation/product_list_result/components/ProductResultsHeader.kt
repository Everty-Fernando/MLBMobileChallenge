package br.com.everty.product.presentation.product_list_result.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.components.topbar.AppSearchTopBar
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductResultsHeader(
    query: String,
    onQueryChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    AppSearchTopBar(
        query = query,
        onQueryChange = onQueryChange,
        onBackClick = onBackClick,
        onSearchClick = onSearchClick
    )
}

@Preview
@Composable
fun ProductResultsHeaderPreview() {
    AppTheme {
        ProductResultsHeader(
            query = "teste",
            onQueryChange = {},
            onBackClick = {},
            onSearchClick = {},
        )
    }
}
