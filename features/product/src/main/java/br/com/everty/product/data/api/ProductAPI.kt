package br.com.everty.product.data.api

import br.com.everty.product.data.model.HighlightedProductsResponse
import br.com.everty.product.data.model.ProductModelResponse
import br.com.everty.product.data.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductAPI {
    @GET("highlights/MLB/category/{categoryId}")
    suspend fun getProductsHighlightsList(
        @Path("categoryId") category: String = "MLB432825" //Fixo para teste
    ): Response<HighlightedProductsResponse>

    @GET("products/{productId}")
    suspend fun getProductById(
        @Path("productId") productId: String
    ): Response<ProductResponse>
}