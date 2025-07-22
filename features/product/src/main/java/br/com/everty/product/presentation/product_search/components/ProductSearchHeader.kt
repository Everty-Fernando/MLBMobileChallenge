package br.com.everty.product.presentation.product_search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.components.topbar.AppAnimatedSearchTopBar
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductSearchHeader(
    query: String,
    isSearching: Boolean,
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    onSearchIconClick: () -> Unit,
    onCloseSearch: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colors.highlight)
            .padding(AppSpacing.regular)
    ) {
        AppAnimatedSearchTopBar(
            searchText = query,
            isSearching = isSearching,
            onSearchIconClick = onSearchIconClick,
            onSearchTextChange = onQueryChange,
            onCloseSearch = onCloseSearch,
            onSearchClick = onSearchClick
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ProductSearchHeaderPreview() {
    AppTheme {
        ProductSearchHeader(
            query = "",
            onQueryChange = {  },
            isSearching = true,
            onSearchClick = {},
            onSearchIconClick = {},
            onCloseSearch = {},
        )
    }
}

