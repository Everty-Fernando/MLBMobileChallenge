package br.com.everty.product.presentation.product_details.state

import br.com.everty.product.domain.model.ProductDetailsModelUI

data class ProductDetailsUIState(
    val productDetails: ProductDetailsModelUI? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val showRetry: Boolean = false,
)
