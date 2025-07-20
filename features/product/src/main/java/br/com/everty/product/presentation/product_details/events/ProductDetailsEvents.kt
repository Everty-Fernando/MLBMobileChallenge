package br.com.everty.product.presentation.product_details.events

interface ProductDetailsEvents {
    fun onBackClick()
    fun onFavoriteClick()
    fun onShareClick()
    fun onAddCartClick()
    fun onBuyClick()
    fun onRetry()
}