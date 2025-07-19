package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.components.text.AppTextWithIcon
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductDetailsFeatures(
    features: List<String>
) {
    Column (modifier = Modifier.padding(horizontal = AppSpacing.regular)) {
        Text(
            text = stringResource(R.string.product_details_features),
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(AppDimens.micro))
        features.forEach {
            AppTextWithIcon(
                icon = Icons.Default.CheckCircle,
                text = it,
                iconTint = AppTheme.colors.primary
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailsFeaturesPreview() {
    ProductDetailsFeatures(
        features = listOf(
            "Tela Super Retina XDR de 6.7 polegadas",
            "Chip A16 Bionic",
            "Câmera de 48MP",
            "Face ID",
            "iOS 16 com novas funções"
        )
    )
}
