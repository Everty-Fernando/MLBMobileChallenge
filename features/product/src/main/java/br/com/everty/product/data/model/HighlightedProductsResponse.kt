package br.com.everty.product.data.model

import com.google.gson.annotations.SerializedName

data class HighlightedProductsResponse(
    @SerializedName("content")
    val content: List<HighlightProductResponse>
)

data class HighlightProductResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("type")
    val type: String
)
