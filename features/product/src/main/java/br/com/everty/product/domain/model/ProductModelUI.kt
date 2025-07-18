package br.com.everty.product.domain.model

data class ProductModelUI(
    val id: String,
    val imageUrl: String,
    val title: String,
    val currentPrice: String,
    val originalPrice: String? = null,
    val isNew: Boolean = false,
    val rating: Float? = null,
    val ratingCount: Int? = null,
    val hasFreeShipping: Boolean = false,
    val isFavorite: Boolean = false
)
