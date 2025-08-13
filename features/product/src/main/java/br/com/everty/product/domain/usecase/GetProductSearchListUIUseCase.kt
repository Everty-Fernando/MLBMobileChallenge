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

class GetProductSearchListUIUseCase(
    private val repository: ProductRepository,
    private val mapper: ProductUIMapper
) {
    operator fun invoke(query: String): Flow<Result<List<ProductModelUI>>> {
        return repository.searchProducts(query)
            .map { result -> result.mapResultList { mapper.toObject(it) } }
            .flowOn(Dispatchers.IO)
    }
} 