package br.com.everty.shared.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiBuilder(
    private val url: String,
) {

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private val okHttpBuilder by lazy {
        OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(createHeaderInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
    }

    val client: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun createHeaderInterceptor() = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE_JSON)
            .addHeader(HEADER_AUTHORIZATION, "$AUTH_PREFIX $ACCESS_TOKEN")
            .build()
        chain.proceed(request)
    }

    companion object {
        private const val CONNECT_TIMEOUT = 10L
        private const val READ_TIMEOUT = 20L
        private const val WRITE_TIMEOUT = 20L
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val HEADER_AUTHORIZATION = "Authorization"
        private const val CONTENT_TYPE_JSON = "application/json"
        private const val AUTH_PREFIX = "Bearer"
        private const val ACCESS_TOKEN = "SEU_TOKEN"
    }

}
