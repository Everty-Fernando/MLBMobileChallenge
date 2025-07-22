package br.com.everty.product.presentation.product_list_result.events

interface ProductResultEvents {
    fun onBackClick()
    fun onSearchClick(query: String)
    fun onProductDetailsClick(productId: String)
    fun onValueChangeSearch(value: String)
    fun onRetry()
}