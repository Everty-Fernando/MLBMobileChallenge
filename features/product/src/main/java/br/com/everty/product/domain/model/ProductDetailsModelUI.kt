package br.com.everty.product.domain.model

data class ProductDetailsModelUI(
    val id: String,
    val imageUrls: List<String>,
    val isFavorite: Boolean = false,
    val title: String,
    val rating: Float,
    val ratingCount: Int,
    val originalPrice: String?,
    val currentPrice: String,
    val hasFreeShipping: Boolean,
    val sellerName: String,
    val stockAvailable: Int,
    val arrivesTomorrow: Boolean,
    val hasInstallments: Boolean,
    val hasWarranty: Boolean,
    val description: String,
    val features: List<String>
)
