package br.com.everty.product.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("pictures")
    val pictures: List<Picture>,

    @SerializedName("attributes")
    val attributes: List<Attribute>,

    @SerializedName("main_features")
    val mainFeatures: List<Feature>,

    @SerializedName("permalink")
    val permalink: String?,

    @SerializedName("short_description")
    val shortDescription: ShortDescription?
)

data class Picture(
    @SerializedName("url")
    val url: String
)

data class Attribute(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String?,

    @SerializedName("value_name")
    val valueName: String?
)

data class Feature(
    @SerializedName("text")
    val text: String
)

data class ShortDescription(
    @SerializedName("content")
    val content: String
)

