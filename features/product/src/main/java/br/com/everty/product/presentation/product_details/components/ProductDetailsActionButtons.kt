package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.components.button.AppActionButton
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing

@Composable
fun ProductDetailsActionButtons(
    onAddCartClick: () -> Unit,
    onBuyClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppSpacing.base),
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.mini)
    ) {
        AppActionButton(
            modifier = Modifier.fillMaxWidth(0.6f),
            text = stringResource(R.string.product_details_btn_add_cart),
            isPrimary = false,
            onClick = onAddCartClick
        )

        AppActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.product_details_btn_buy),
            onClick = onBuyClick
        )
    }
}

@Preview
@Composable
private fun ProductDetailsActionButtonsPreview() {
    ProductDetailsActionButtons(
        onAddCartClick = {},
        onBuyClick = {}
    )
}

