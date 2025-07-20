package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.components.rating.AppRatingInfo
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductDetailsMainInfo(
    title: String,
    rating: Float,
    ratingCount: Int,
    currentPrice: String,
    originalPrice: String?,
    hasFreeShipping: Boolean
) {
    Column(
        modifier = Modifier.padding(horizontal = AppSpacing.base),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.small)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.onBackground
            )
        )

        AppRatingInfo(rating = rating, totalReviews = ratingCount)

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.small)
            ) {
                Text(
                    text = currentPrice,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = AppTheme.colors.onBackground
                    )
                )
                
                originalPrice?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleLarge.copy(
                            textDecoration = TextDecoration.LineThrough,
                            color = AppTheme.colors.secondaryText
                        )
                    )
                }
            }
            
            if (hasFreeShipping) {
                Spacer(modifier = Modifier.height(AppSpacing.smallest))
                Text(
                    text = stringResource(R.string.product_details_free_shipping),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = AppTheme.colors.success,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsMainInfoPreview() {
    ProductDetailsMainInfo(
        title = "iPhone 14 Pro Max 128GB - Deep Purple",
        rating = 4.8f,
        ratingCount = 1247,
        currentPrice = "R$ 4.299,99",
        originalPrice = "R$ 4.799,99",
        hasFreeShipping = true
    )
}

