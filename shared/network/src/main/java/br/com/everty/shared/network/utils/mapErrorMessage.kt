package br.com.everty.shared.network.utils

fun mapErrorMessage(code: Int?): String {
    return when (code) {
        400 -> "Requisição inválida. Verifique os dados."
        401 -> "Sessão expirada. Faça login novamente."
        403 -> "Você não tem permissão para acessar esse recurso."
        404 -> "Recurso não encontrado."
        500 -> "Erro interno do servidor. Tente novamente mais tarde."
        else -> "Erro inesperado. Tente novamente."
    }
}
