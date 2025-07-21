package br.com.everty.product.repository

import br.com.everty.product.data.api.ProductAPI
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.shared.network.extensions.toTypedError
import br.com.everty.shared.network.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import br.com.everty.shared.utils.Result
import timber.log.Timber

class ProductRepositoryImpl(
    private val service: ProductAPI
) : ProductRepository {

    override fun getHighlightedProducts(): Flow<Result<List<ProductResponse>>> = flow {
        when (val highlightsResult = safeApiCall { service.getProductsHighlightsList() }) {
            is Result.Success -> {
                val productIds = highlightsResult.data.content.map { it.id }.take(6)

                if (productIds.isEmpty()) {
                    emit(Result.Success(emptyList()))
                } else {
                    val productDetails = fetchProductDetailsByIds(productIds)
                    emit(Result.Success(productDetails))
                }
            }

            is Result.Error -> {
                emit(highlightsResult.toTypedError())
            }
        }
    }

    override fun searchProducts(query: String): Flow<Result<List<ProductResponse>>> = flow {
        when (val result = safeApiCall { service.searchProducts(query = query) }) {
            is Result.Success -> emit(Result.Success(result.data.productsResult))
            is Result.Error -> emit(result.toTypedError())
        }
    }

    override fun getProductDetails(productId: String): Flow<Result<ProductResponse>> = flow {
        when (val result = safeApiCall { service.getProductById(productId) }) {
            is Result.Success -> emit(Result.Success(result.data))
            is Result.Error -> emit(result.toTypedError())
        }
    }

    private suspend fun fetchProductDetailsByIds(ids: List<String>): List<ProductResponse> {
        val details = ids.mapNotNull { id ->
            when (val result = safeApiCall { service.getProductById(id) }) {
                is Result.Success -> result.data
                is Result.Error -> {
                    Timber.w("Falha ao carregar produto com ID: $id — motivo: ${result.message}")
                    null
                }
            }
        }

        if (details.size < ids.size) {
            Timber.i("Produtos ignorados: ${ids.size - details.size}")
        }

        return details
    }
}
