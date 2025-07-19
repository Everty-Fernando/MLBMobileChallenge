package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.components.text.AppTextWithIcon
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing

@Composable
fun ProductDetailsBenefits(
    benefits: List<String>
) {
    Column(modifier = Modifier.padding(horizontal = AppSpacing.regular)) {
        benefits.forEach {
            AppTextWithIcon(
                icon = Icons.Default.CheckCircle,
                text = it
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailsBenefitsPreview() {
    ProductDetailsBenefits(
        benefits = listOf(
            "Chega grátis amanhã",
            "Pague em até 12x sem juros",
            "Garantia oficial de 1 ano"
        )
    )
}

