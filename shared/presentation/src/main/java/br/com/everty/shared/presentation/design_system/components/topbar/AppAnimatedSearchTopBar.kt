package br.com.everty.shared.presentation.design_system.components.topbar

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.design_system.components.search_bar.AppSearchBar
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.R
import br.com.everty.shared.presentation.design_system.components.logo.AppLogo

@Composable
fun AppAnimatedSearchTopBar(
    modifier: Modifier = Modifier,
    logoResId: Int = R.drawable.meli_logo,
    searchText: String,
    isSearching: Boolean,
    onSearchIconClick: () -> Unit,
    onSearchTextChange: (String) -> Unit,
    onCloseSearch: () -> Unit,
    onSearchClick: () -> Unit = {}
) {
    val focusRequester = remember { FocusRequester() }
    
    LaunchedEffect(isSearching) {
        if (isSearching) {
            focusRequester.requestFocus()
        }
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        color = AppTheme.colors.highlight,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            AnimatedContent(targetState = isSearching) { searching ->
                if (!searching) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        AppLogo(
                            sizeLogo = 32.dp,
                            imgLogo = logoResId
                        )

                        Icon(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .clickable { onSearchIconClick() },
                            imageVector = Icons.Default.Search,
                            contentDescription = "Pesquisar",
                            tint = AppTheme.colors.primary,
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                    ) {
                        AppSearchBar(
                            text = searchText,
                            placeholderText = "Buscar produto...",
                            onValueChange = onSearchTextChange,
                            onSearchClick = onSearchClick,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Pesquisar"
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester)
                        )
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Fechar busca",
                            tint = Color.Gray,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 8.dp)
                                .size(24.dp)
                                .clickable { onCloseSearch() }
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "TopBar - Estado Normal")
@Composable
private fun AppAnimatedSearchTopBarNormalPreview() {
    AppAnimatedSearchTopBar(
        logoResId = R.drawable.meli_logo, // Substitua pelo seu logo real
        searchText = "",
        isSearching = false,
        onSearchIconClick = {},
        onSearchTextChange = {},
        onCloseSearch = {}
    )
}

@Preview(name = "TopBar - Estado Busca")
@Composable
private fun AppAnimatedSearchTopBarSearchPreview() {
    AppAnimatedSearchTopBar(
        logoResId = R.drawable.meli_logo,
        searchText = "Celular",
        isSearching = true,
        onSearchIconClick = {},
        onSearchTextChange = {},
        onCloseSearch = {}
    )
} 