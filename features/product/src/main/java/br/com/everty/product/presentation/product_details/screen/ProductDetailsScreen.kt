package br.com.everty.product.presentation.product_details.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.product.presentation.product_details.components.ProductDetailsActionButtons
import br.com.everty.product.presentation.product_details.components.ProductDetailsBenefits
import br.com.everty.product.presentation.product_details.components.ProductDetailsDescription
import br.com.everty.product.presentation.product_details.components.ProductDetailsFeatures
import br.com.everty.product.presentation.product_details.components.ProductDetailsImageCarousel
import br.com.everty.product.presentation.product_details.components.ProductDetailsLoading
import br.com.everty.product.presentation.product_details.components.ProductDetailsMainInfo
import br.com.everty.product.presentation.product_details.components.ProductDetailsSellerInfo
import br.com.everty.product.presentation.product_details.events.ProductDetailsEvents
import br.com.everty.product.presentation.product_details.preview.productDetailsUIStatePreview
import br.com.everty.product.presentation.product_details.state.ProductDetailsUIState
import br.com.everty.shared.presentation.design_system.components.AppScaffold
import br.com.everty.shared.presentation.design_system.components.divider.AppDivider
import br.com.everty.shared.presentation.design_system.components.topbar.AppTopBar
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.dimens.AppDimens

@Composable
fun ProductDetailsScreen(
    state: ProductDetailsUIState,
    events: ProductDetailsEvents,
) {
    AppScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colors.background,
    ) {
        ProductDetailsScreenContent(
            state = state,
            onBackClick = events::onBackClick,
            onFavoriteClick = events::onFavoriteClick,
            onShareClick = events::onShareClick,
            onAddCartClick = events::onAddCartClick,
            onBuyClick = events::onBuyClick
        )
    }
}

@Composable
fun ProductDetailsScreenContent(
    state: ProductDetailsUIState,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onShareClick: () -> Unit,
    onAddCartClick: () -> Unit,
    onBuyClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            AppTopBar(
                onBackClick = onBackClick,
                onFavoriteClick = onFavoriteClick,
                onShareClick = onShareClick,
            )

            if (state.isLoading) {
                ProductDetailsLoading()
            } else {
                state.productDetails?.let { product ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            ProductDetailsImageCarousel(
                                imageUrls = product.imageUrls,
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(AppDimens.xSmall))

                            ProductDetailsMainInfo(
                                title = product.title,
                                rating = product.rating,
                                ratingCount = product.ratingCount,
                                currentPrice = product.currentPrice,
                                originalPrice = product.originalPrice,
                                hasFreeShipping = product.hasFreeShipping
                            )

                            Spacer(modifier = Modifier.height(AppSpacing.small))

                            ProductDetailsSellerInfo(
                                sellerName = product.sellerName,
                                stockAvailable = product.stockAvailable
                            )

                            Spacer(modifier = Modifier.height(AppSpacing.small))

                            ProductDetailsBenefits(
                                arrivesTomorrow = product.arrivesTomorrow,
                                hasInstallments = product.hasInstallments,
                                hasWarranty = product.hasWarranty,
                            )

                            AppDivider(
                                modifier = Modifier.padding(vertical = AppSpacing.small)
                            )

                            ProductDetailsDescription(description = product.description)

                            Spacer(modifier = Modifier.height(AppSpacing.small))

                            ProductDetailsFeatures(features = product.features)

                            Spacer(modifier = Modifier.height(AppSpacing.small))
                        }
                    }
                }
            }
        }
        //Todo(pending implementation)
        /*Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            ProductDetailsActionButtons(
                onAddCartClick = onAddCartClick,
                onBuyClick = onBuyClick
            )
        }*/
    }
}

@Preview
@Composable
private fun ProductSearchResultScreenPreview() {
    AppTheme {
        ProductDetailsScreenContent(
            state = productDetailsUIStatePreview,
            onBackClick = {},
            onFavoriteClick = {},
            onShareClick = {},
            onAddCartClick = {},
            onBuyClick = {}
        )
    }
}

