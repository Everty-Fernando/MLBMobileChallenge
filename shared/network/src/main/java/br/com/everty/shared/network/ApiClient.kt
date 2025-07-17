package br.com.everty.shared.network

import retrofit2.Retrofit

private const val BASE_DEV = "https://api.mercadolibre.com/"

class ApiClient {

    val client: Retrofit by lazy {
        ApiBuilder(
            url = BASE_DEV,
        ).client
    }
}