package br.com.everty.product.repository

import br.com.everty.product.data.model.ProductResponse
import br.com.everty.shared.utils.Result
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getHighlightedProducts(): Flow<Result<List<ProductResponse>>>
}
