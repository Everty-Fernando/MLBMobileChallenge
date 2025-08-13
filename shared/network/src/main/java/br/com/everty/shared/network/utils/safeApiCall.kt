package br.com.everty.shared.network.utils

import retrofit2.Response
import br.com.everty.shared.utils.Result
import timber.log.Timber

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Result<T> {
    return  try {
        val response = apiCall()
        response.toResult()
    } catch (e: Exception) {
        Timber.e(e, "safeApiCall failed: ${e.message}")
        Result.Error(
            message = "Erro de conexão. Verifique sua internet.",
            showRetry = true
        )
    }
}

private fun <T> Response<T>.toResult(): Result<T> {
    val httpCode = code()
    return if (isSuccessful) {
        body()?.let { Result.Success(it) }
            ?: run {
                Timber.w("safeApiCall: body nulo (code=$httpCode)")
                emptyBodyError(httpCode)
            }
    } else {
        val errorStr = errorBodySafe()
        Timber.w("safeApiCall HTTP error: code=$httpCode, message=$errorStr")
        Result.Error(
            message = mapErrorMessage(httpCode),
            code = httpCode,
            showRetry = shouldRetry(httpCode)
        )
    }
}

private fun Response<*>.errorBodySafe(): String? =
    try { errorBody()?.string() } catch (_: Exception) { null }

private fun emptyBodyError(code: Int): Result.Error =
    Result.Error(
        message = "Ocorreu um erro inesperado. Tente novamente mais tarde.",
        code = code,
        showRetry = true
    )

private fun shouldRetry(code: Int?): Boolean =
    code == 404 || (code ?: 0) in 500..599
