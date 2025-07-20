package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.components.text.AppTextWithIcon
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductDetailsBenefits(
    arrivesTomorrow: Boolean,
    hasInstallments: Boolean,
    hasWarranty: Boolean,
) {
    Column(
        modifier = Modifier.padding(horizontal = AppSpacing.base),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.small)
    ) {
        if (arrivesTomorrow) {
              AppTextWithIcon(
                  icon = Icons.Default.DeliveryDining,
                  iconTint = AppTheme.colors.success,
                  text = stringResource(R.string.product_details_benefit_shipping)
              )
        }

        if (hasInstallments) {
            AppTextWithIcon(
                icon = Icons.Default.CreditCard,
                iconTint = AppTheme.colors.primaryVariant,
                text = stringResource(R.string.product_details_benefit_installments)
            )
        }

        if (hasWarranty) {
            AppTextWithIcon(
                icon = Icons.Outlined.Shield,
                iconTint = AppTheme.colors.success,
                text = stringResource(R.string.product_details_benefit_warranty)
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailsBenefitsPreview() {
    ProductDetailsBenefits(
        arrivesTomorrow = true,
        hasInstallments = true,
        hasWarranty = true,
    )
}

