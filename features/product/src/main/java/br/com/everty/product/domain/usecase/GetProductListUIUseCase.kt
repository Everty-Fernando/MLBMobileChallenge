package br.com.everty.product.domain.usecase

import br.com.everty.product.domain.mappers.ProductUIMapper
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import br.com.everty.shared.utils.Result
import br.com.everty.shared.utils.extensions.mapResultList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class GetProductListUIUseCase(
    private val repository: ProductRepository,
    private val mapper: ProductUIMapper
) {

    operator fun invoke(): Flow<Result<List<ProductModelUI>>> = getProductList()

    private fun getProductList(): Flow<Result<List<ProductModelUI>>> {
        return repository.getHighlightedProducts()
            .map { result -> result.mapResultList { mapper.toObject(it) } }
            .flowOn(Dispatchers.IO)
    }
}
