package br.com.everty.shared.network.extensions

import br.com.everty.shared.utils.Result

fun <T> Result.Error.toTypedError(): Result<T> {
    return Result.Error(
        message = message,
        code = code,
        showRetry = showRetry,
        exception = exception
    )
}

