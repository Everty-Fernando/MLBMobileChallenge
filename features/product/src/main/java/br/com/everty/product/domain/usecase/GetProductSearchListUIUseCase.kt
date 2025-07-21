package br.com.everty.product.domain.usecase

import br.com.everty.product.domain.mappers.ProductUIMapper
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import br.com.everty.shared.utils.Result

class GetProductSearchListUIUseCase(
    private val repository: ProductRepository,
    private val mapper: ProductUIMapper
) {
    operator fun invoke(query: String): Flow<Result<List<ProductModelUI>>> {
        return repository.searchProducts(query)
            .map { result ->
                when (result) {
                    is Result.Success -> Result.Success(result.data.map { mapper.toObject(it) })
                    is Result.Error -> Result.Error(
                        message = result.message,
                        code = result.code,
                        showRetry = result.showRetry,
                        exception = result.exception
                    )
                }
            }
    }
} 