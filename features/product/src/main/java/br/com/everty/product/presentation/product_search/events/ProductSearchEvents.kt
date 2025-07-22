package br.com.everty.product.presentation.product_search.events


interface ProductSearchEvents {
    fun onSearchClick(query: String)
    fun onProductDetailsClick(productId: String)
    fun onRetry()
    fun onSearchIconClick()
    fun onCloseSearch()
    fun onValueChangeSearch(value: String)
}