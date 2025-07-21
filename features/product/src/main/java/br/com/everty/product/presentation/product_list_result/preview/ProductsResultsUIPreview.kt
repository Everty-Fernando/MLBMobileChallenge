package br.com.everty.product.presentation.product_list_result.preview

import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.presentation.product_list_result.state.ProductResultsUIState

val productsPreview = listOf(
    ProductModelUI(
        id = "1",
        imageUrl = "https://placehold.co/600x400",
        title = "iPhone 14 Pro Max 128GB - Deep Purple",
        currentPrice = "R$ 4.299,99",
        originalPrice = "R$ 4.799,99",
        rating = 4.8f,
        ratingCount = 1247,
        hasFreeShipping = true,
        isFavorite = false
    ),
    ProductModelUI(
        id = "2",
        imageUrl = "https://placehold.co/600x400",
        title = "Samsung Galaxy S23 Ultra 256GB",
        currentPrice = "R$ 3.599,99",
        rating = 4.6f,
        ratingCount = 980,
        hasFreeShipping = false,
        isFavorite = true
    )
)

val productResultsUIStatePreview = ProductResultsUIState(
    productList = productsPreview
)
