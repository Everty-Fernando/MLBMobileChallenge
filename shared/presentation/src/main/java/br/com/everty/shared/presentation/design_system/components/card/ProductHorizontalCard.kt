package br.com.everty.shared.presentation.design_system.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.R
import br.com.everty.shared.presentation.design_system.components.badge.AppBadgeLabel
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.components.rating.AppRatingInfo
import br.com.everty.shared.presentation.design_system.dimens.AppDimens

@Composable
fun ProductHorizontalCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    rating: Float,
    reviewCount: Int,
    priceOriginal: String? = null,
    pricePromotional: String,
    hasFreeShipping: Boolean = false,
    onProductClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onProductClick() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.micro),
        border = BorderStroke(AppDimens.tiny, AppTheme.colors.divider)
    ) {
        Row(
            modifier = Modifier
                .padding(AppSpacing.base),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(MaterialTheme.shapes.small)
            )

            Spacer(modifier = Modifier.width(AppSpacing.base))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = AppTheme.colors.onBackground,
                        fontWeight = FontWeight.SemiBold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                AppRatingInfo(
                    rating = rating,
                    totalReviews = reviewCount
                )

                Spacer(modifier = Modifier.height(AppSpacing.small))

                priceOriginal?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = AppTheme.colors.secondaryText,
                            textDecoration = TextDecoration.LineThrough
                        )
                    )
                }

                Text(
                    text = pricePromotional,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = AppTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                )

                if (hasFreeShipping) {
                    Text(
                        modifier = Modifier.padding(top = AppSpacing.micro),
                        text = stringResource(R.string.label_free_shipping),
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = AppTheme.colors.success
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ProductHorizontalCardSkeleton(modifier: Modifier = Modifier) {
    AppShimmerLoader { brush ->
        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.micro),
            border = BorderStroke(AppDimens.tiny, AppTheme.colors.divider)
        ) {
            Row(
                modifier = Modifier
                    .padding(AppSpacing.base),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Image placeholder
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(brush)
                )

                Spacer(modifier = Modifier.width(AppSpacing.base))

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    // Title
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(brush)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Rating
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(12.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(brush)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Original price
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(12.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(brush)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Promotional price
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(brush)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun ProductHorizontalCardPreview() {
    AppTheme {
        ProductHorizontalCard(
            imageUrl = "https://images.unsplash.com/photo-1677086636713-b2f4e6fd0e4e",
            title = "iPhone 14 Pro Max 128GB - Deep Purple",
            rating = 4.8f,
            reviewCount = 1247,
            priceOriginal = "R$ 4.799,99",
            pricePromotional = "R$ 4.299,99",
            hasFreeShipping = true,
            onProductClick = {}
        )
    }
}

@Preview
@Composable
private fun ProductHorizontalCardSkeletonPreview() {
    AppTheme {
        ProductHorizontalCardSkeleton()
    }
}

