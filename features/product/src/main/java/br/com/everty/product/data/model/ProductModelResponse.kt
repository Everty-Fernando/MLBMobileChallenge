package br.com.everty.product.data.model

import com.google.gson.annotations.SerializedName

data class ProductModelResponse(
    @SerializedName("results")
    val productsResult: List<ProductResponse>,
)

