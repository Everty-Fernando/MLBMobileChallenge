package br.com.everty.product.presentation.product_details.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.components.badge.AppBadgeLabel
import br.com.everty.shared.presentation.design_system.components.rating.AppRatingInfo
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
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)

        AppRatingInfo(rating = rating, totalReviews = ratingCount)

        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            originalPrice?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall.copy(
                        textDecoration = TextDecoration.LineThrough,
                        color = AppTheme.colors.onBackground.copy(alpha = 0.6f)
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(text = currentPrice, style = MaterialTheme.typography.titleLarge)
        }

        if (hasFreeShipping) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.product_details_free_shipping),
                style = MaterialTheme.typography.bodySmall.copy(color = AppTheme.colors.success)
            )
        }
    }
}

@Preview
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

