package br.com.everty.product.presentation.product_search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.components.logo.AppLogo
import br.com.everty.shared.presentation.design_system.components.search_bar.AppSearchBar
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductSearchHeader(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(AppTheme.colors.highlight)
            .padding(AppSpacing.regular)
    ) {
        AppLogo(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(AppSpacing.mini))

        Text(
            text = stringResource(R.string.product_search_title_header),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(AppSpacing.regular))

        AppSearchBar(
            modifier = Modifier.fillMaxWidth(),
            text = query,
            placeholderText = stringResource(R.string.product_search_placeholder),
            onValueChange = onQueryChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de busca",
                    tint = MaterialTheme.colorScheme.outline
                )
            },
            onSearchClick = onSearchClick
        )

        Spacer(modifier = Modifier.height(AppSpacing.regular))
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSearchHeaderPreview() {
    var query by remember { mutableStateOf("") }
    AppTheme {
        
        ProductSearchHeader(
            query = query,
            onQueryChange = { query = it },
            onSearchClick = { /* TODO */ }
        )
    }
}

