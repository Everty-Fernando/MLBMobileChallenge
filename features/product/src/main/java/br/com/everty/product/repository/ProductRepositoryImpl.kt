package br.com.everty.product.repository

import br.com.everty.product.data.api.ProductAPI
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.shared.network.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import br.com.everty.shared.utils.Result

class ProductRepositoryImpl(
    private val service: ProductAPI
) : ProductRepository {

    //Todo(pending refactor)
    override fun getHighlightedProducts(): Flow<Result<List<ProductResponse>>> = flow {
        when (val highlightsResult = safeApiCall { service.getProductsHighlightsList() }) {

            is Result.Success -> {
                val productIds = highlightsResult.data.content.map { it.id }.take(6)

                if (productIds.isEmpty()) {
                    emit(Result.Success(emptyList()))
                    return@flow
                }

                val productDetails = productIds.mapNotNull { id ->
                    when (val productResult = safeApiCall { service.getProductById(id) }) {
                        is Result.Success -> productResult.data
                        is Result.Error -> null
                    }
                }

                emit(Result.Success(productDetails))
            }

            is Result.Error -> {
                emit(
                    Result.Error(
                    message = highlightsResult.message,
                    code = highlightsResult.code,
                    showRetry = highlightsResult.showRetry,
                    exception = highlightsResult.exception
                ))
            }
        }
    }

    override fun searchProducts(query: String): Flow<Result<List<ProductResponse>>> = flow {
        when (val result = safeApiCall { service.searchProducts(query = query) }) {
            is Result.Success -> {
                emit(Result.Success(result.data.productsResult))
            }
            is Result.Error -> {
                emit(Result.Error(
                    message = result.message,
                    code = result.code,
                    showRetry = result.showRetry,
                    exception = result.exception
                ))
            }
        }
    }
}
