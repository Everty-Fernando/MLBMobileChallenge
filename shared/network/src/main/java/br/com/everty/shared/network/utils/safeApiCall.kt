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
                Timber.w("safeApiCall: resposta vazia para código ${response.code()}")
                Result.Error(
                    message = "Ocorreu um erro inesperado. Tente novamente mais tarde.",
                    code = response.code(),
                    showRetry = true
                )
            }
        } else {
            val code = response.code()
            Timber.w("safeApiCall HTTP error: code=$code, message=${response.errorBody()?.string()}")
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