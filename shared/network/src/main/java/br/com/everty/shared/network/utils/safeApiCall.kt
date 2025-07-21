package br.com.everty.shared.network.utils

import retrofit2.Response
import br.com.everty.shared.utils.Result
import timber.log.Timber

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Result<T> {
    return try {
        val response = apiCall()

        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Result.Success(body)
            } else {
               Result.Error(
                    message = "Resposta vazia",
                    code = response.code(),
                    showRetry = true
                )
            }
        } else {
            val code = response.code()
           Result.Error(
                message = mapErrorMessage(code),
                code = code,
                showRetry = code in listOf(500, 404)
            )
        }
    } catch (e: Exception) {
        Timber.e(e, "safeApiCall failed: ${e.message}")
        Result.Error(
            message = "Erro de conexão. Verifique sua internet.",
            exception = e,
            showRetry = true
        )
    }
}