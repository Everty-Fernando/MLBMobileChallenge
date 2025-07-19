package br.com.everty.product.domain.model

data class ProductDetailsModelUI(
    val id: String,
    val imageUrls: List<String>,
    val isNew: Boolean,
    val isFavorite: Boolean,
    val title: String,
    val rating: Float,
    val ratingCount: Int,
    val originalPrice: String?,
    val currentPrice: String,
    val hasFreeShipping: Boolean,
    val sellerName: String,
    val sellerLink: String?,
    val stockAvailable: Int,
    val benefits: List<String>,
    val description: String,
    val features: List<String>
)
