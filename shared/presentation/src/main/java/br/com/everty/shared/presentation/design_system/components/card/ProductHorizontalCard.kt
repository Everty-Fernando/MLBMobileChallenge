package br.com.everty.shared.presentation.design_system.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.R
import br.com.everty.shared.presentation.design_system.components.badge.AppBadgeLabel
import br.com.everty.shared.presentation.design_system.components.rating.AppRatingInfo
import br.com.everty.shared.presentation.design_system.dimens.AppDimens

@Composable
fun ProductHorizontalCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    isNew: Boolean = false,
    isFavorite: Boolean = false,
    title: String,
    rating: Double,
    reviewCount: Int,
    priceOriginal: String? = null,
    pricePromotional: String,
    hasFreeShipping: Boolean = false,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .border(
                width = 1.dp,
                color = AppTheme.colors.divider,
                shape = MaterialTheme.shapes.medium
            )
            .padding(AppSpacing.base)
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
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = AppSpacing.micro),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (isNew) {
                    AppBadgeLabel(text = stringResource(R.string.label_new))
                    Spacer(modifier = Modifier.width(AppSpacing.small))
                }

                if (isFavorite) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorito",
                        tint = AppTheme.colors.secondaryText,
                        modifier = Modifier.size(AppDimens.medium)
                    )
                }
            }

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

@Preview
@Composable
fun ProductHorizontalCardPreview() {
    AppTheme {
        ProductHorizontalCard(
            imageUrl = "https://images.unsplash.com/photo-1677086636713-b2f4e6fd0e4e",
            isNew = true,
            isFavorite = true,
            title = "iPhone 14 Pro Max 128GB - Deep Purple",
            rating = 4.8,
            reviewCount = 1247,
            priceOriginal = "R$ 4.799,99",
            pricePromotional = "R$ 4.299,99",
            hasFreeShipping = true,
        )
    }
}

