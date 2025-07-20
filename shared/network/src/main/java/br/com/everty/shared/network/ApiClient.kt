package br.com.everty.shared.network

import retrofit2.Retrofit

class ApiClient {

    val client: Retrofit by lazy {
        ApiBuilder(
            url = BuildConfig.BASE_DEV,
        ).client
    }
}