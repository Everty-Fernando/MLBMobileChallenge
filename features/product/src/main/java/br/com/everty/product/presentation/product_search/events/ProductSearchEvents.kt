package br.com.everty.product.presentation.product_search.events

interface ProductSearchEvents {
    fun onValueChangeSearch(value: String)
    fun onSearchClick(query: String)
    fun onProductDetailsClick(productId: String)
    fun onRetry()
}