package br.com.everty.product.presentation.product_details.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import androidx.compose.material3.MaterialTheme
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
import br.com.everty.shared.presentation.design_system.dimens.AppDimens

@Composable
fun ProductDetailsScreen(
    state: ProductDetailsUIState,
    events: ProductDetailsEvents,
) {
    AppScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        ProductDetailsScreenContent(
            state = state,
            onBackClick = events::onBackClick,
            onFavoriteClick = events::onFavoriteClick,
            onShareClick = events::onShareClick,
            onPageImageChanged = events::onPageImageChanged,
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
    onPageImageChanged: (Int) -> Unit,
    onAddCartClick: () -> Unit,
    onBuyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
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
                            onPageChanged = onPageImageChanged
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

                        Spacer(modifier = Modifier.height(AppDimens.xSmall))

                        ProductDetailsSellerInfo(
                            sellerName = product.sellerName,
                            stockAvailable = product.stockAvailable
                        )

                        Spacer(modifier = Modifier.height(AppDimens.xSmall))

                        ProductDetailsBenefits(
                            arrivesTomorrow = product.arrivesTomorrow,
                            hasInstallments = product.hasInstallments,
                            hasWarranty = product.hasWarranty,
                        )

                        AppDivider(Modifier.padding(vertical = AppDimens.xSmall))

                        ProductDetailsDescription(description = product.description)

                        Spacer(modifier = Modifier.height(AppDimens.xSmall))

                        ProductDetailsFeatures(features = product.features)

                        Spacer(modifier = Modifier.height(AppDimens.small))
                    }

                    item {
                        ProductDetailsActionButtons(
                            onAddCartClick = onAddCartClick,
                            onBuyClick = onBuyClick
                        )
                    }
                }
            }
        }
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
            onPageImageChanged = {},
            onAddCartClick = {},
            onBuyClick = {}
        )
    }
}

