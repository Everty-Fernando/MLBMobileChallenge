package br.com.everty.shared.presentation.design_system.components.search_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.components.input.appSearchTextFieldColors
import br.com.everty.shared.presentation.design_system.shape.AppCornerDefaults

@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    text: String,
    placeholderText: String = "",
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            Text(
                text = placeholderText,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onBackground
        ),
        colors = appSearchTextFieldColors(),
        shape = AppCornerDefaults.large,
        leadingIcon = leadingIcon
    )
}

@Composable
@Preview
private fun AppSearchBarPreview() {
    var text by remember { mutableStateOf("") }

    AppSearchBar(
        text = text,
        placeholderText = "Buscar produto...",
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondaryContainer
            )
        },
        onValueChange = { text = it }
    )
}