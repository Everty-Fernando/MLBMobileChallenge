package br.com.everty.product.domain.usecase

import br.com.everty.product.domain.mappers.ProductDetailsUIMapper
import br.com.everty.product.domain.model.ProductDetailsModelUI
import br.com.everty.product.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import br.com.everty.shared.utils.Result

class GetProductDetailsUIUseCase(
    private val repository: ProductRepository,
    private val mapper: ProductDetailsUIMapper
) {
    operator fun invoke(productId: String): Flow<Result<ProductDetailsModelUI>> =
        repository.getProductDetails(productId).map { result ->
            when (result) {
                is Result.Success -> Result.Success(mapper.toObject(result.data))
                is Result.Error -> Result.Error(
                    message = result.message,
                    code = result.code,
                    showRetry = result.showRetry,
                    exception = result.exception
                )
            }
        }
} 