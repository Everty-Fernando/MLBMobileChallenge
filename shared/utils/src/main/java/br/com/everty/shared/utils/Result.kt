package br.com.everty.shared.utils

sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(
        val message: String,
        val code: Int? = null,
        val showRetry: Boolean = true,
    ): Result<Nothing>()
}
