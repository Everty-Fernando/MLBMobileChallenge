package br.com.everty.product.domain.model

data class ProductModelUI(
    val id: String,
    val imageUrl: String,
    val title: String,
    val currentPrice: String,
    val originalPrice: String? = null,
    val rating: Float = 3.5f,
    val ratingCount: Int = 1,
    val hasFreeShipping: Boolean = false,
    val isFavorite: Boolean = false
)
