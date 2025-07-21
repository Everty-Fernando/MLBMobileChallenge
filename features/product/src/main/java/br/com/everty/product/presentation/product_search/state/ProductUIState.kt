package br.com.everty.product.presentation.product_search.state

import br.com.everty.product.domain.model.ProductModelUI

data class ProductUIState(
    val productList: List<ProductModelUI> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String= "",
    val errorCode: String = "",
    val showRetry: Boolean = false,
    val inputQuery: String = ""
)
