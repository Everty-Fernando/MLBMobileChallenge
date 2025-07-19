package br.com.everty.shared.presentation.design_system.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.responsive.Dimension
import br.com.everty.shared.presentation.design_system.responsive.responsiveDp
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import coil.compose.AsyncImage

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    currentPrice: String,
    originalPrice: String? = null,
    onProductClick: () -> Unit
) {
    val cardWidth = responsiveDp(0.45f, Dimension.Width)
    val imageHeight = responsiveDp(0.20f, Dimension.Height)

    Card(
        modifier = modifier
            .width(cardWidth)
            .aspectRatio(0.55f)
            .clickable { onProductClick() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.micro),
        border = BorderStroke(AppDimens.tiny, AppTheme.colors.divider)
    ) {
        Column(modifier = Modifier.padding(AppSpacing.base)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight)
                    .aspectRatio(1f)
                    .clip(MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(AppSpacing.small))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = AppTheme.colors.onBackground,
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(AppSpacing.small))

            if (!originalPrice.isNullOrBlank()) {
                Text(
                    text = originalPrice,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AppTheme.colors.secondaryText,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
            }

            Text(
                text = currentPrice,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = AppTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun ProductCardSkeleton(modifier: Modifier = Modifier) {
    val cardWidth = responsiveDp(0.45f, Dimension.Width)
    val imageHeight = responsiveDp(0.20f, Dimension.Height)
    AppShimmerLoader { brush ->
        Card(
            modifier = modifier
                .width(cardWidth)
                .aspectRatio(0.55f),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.micro),
            border = BorderStroke(AppDimens.tiny, AppTheme.colors.divider)
        ) {
            Column(modifier = Modifier.padding(AppSpacing.base)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight)
                        .aspectRatio(1f)
                        .clip(MaterialTheme.shapes.medium)
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(AppSpacing.small))

                // Título
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Preço original
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(12.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Preço atual
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(16.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(brush)
                )
            }
        }
    }
}


@Preview
@Composable
private fun ProductCardPreview() {
    AppTheme {
        ProductCard(
            imageUrl = "https://cdn.awsli.com.br/600x700/1635/1635145/produto/197542173/iphone14promax_3-bdsi23cmtw.png",
            title = "iPhone 14 Pro Max 128GB - Deep Purple",
            currentPrice = "R$ 4.299,99",
            originalPrice = "R$ 4.799,99",
            onProductClick = {}
        )
    }
}

@Preview
@Composable
private fun ProductCardSkeletonPreview() {
    AppTheme {
        ProductCardSkeleton()
    }
}
