package br.com.everty.shared.presentation.design_system.components.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.components.search_bar.AppSearchBar
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun SearchTopBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppSpacing.base),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

        AppSearchBar(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = AppSpacing.small),
            text = query,
            onValueChange = onQueryChange,
            placeholderText = "Buscar produto...",
        )

        IconButton(onClick = onFilterClick) {
            Icon(
                imageVector = Icons.Outlined.List,
                contentDescription = "Filtrar",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview
@Composable
private fun SearchTopBarPreview() {
    var query by remember { mutableStateOf("teste") }

    AppTheme {
        SearchTopBar(
            query = query,
            onQueryChange = { query = it },
            onBackClick = {},
            onFilterClick = {}
        )
    }
}

