package br.com.everty.product.domain.usecase

import br.com.everty.product.domain.mappers.ProductUIMapper
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import br.com.everty.shared.utils.Result

class GetProductListUIUseCase(
    private val repository: ProductRepository,
    private val mapper: ProductUIMapper
) {

    operator fun invoke(): Flow<Result<List<ProductModelUI>>> = getProductList()

    private fun getProductList(): Flow<Result<List<ProductModelUI>>> {
        return repository.getHighlightedProducts()
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
