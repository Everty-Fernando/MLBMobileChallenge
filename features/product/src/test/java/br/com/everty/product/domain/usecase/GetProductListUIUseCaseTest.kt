package br.com.everty.product.domain.usecase

import br.com.everty.product.domain.mappers.ProductUIMapper
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.product.repository.ProductRepository
import br.com.everty.shared.utils.Result
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetProductListUIUseCaseTest {

    private lateinit var repository: ProductRepository
    private lateinit var mapper: ProductUIMapper
    private lateinit var useCase: GetProductListUIUseCase

    @Before
    fun setUp() {
        repository = mockk()
        mapper = mockk()
        useCase = GetProductListUIUseCase(repository, mapper)
    }

    @Test
    fun `invoke emits Result_Success with mapped list when repository returns success`() = runBlocking {
        val productResponse = mockk<ProductResponse>()
        val productUI = mockk<ProductModelUI>()
        coEvery { repository.getHighlightedProducts() } returns flowOf(Result.Success(listOf(productResponse)))
        every { mapper.toObject(productResponse) } returns productUI

        val result = useCase().toList()
        assertTrue(result.first() is Result.Success)
        assertEquals(listOf(productUI), (result.first() as Result.Success).data)
    }

    @Test
    fun `invoke emits Result_Error when repository returns error`() = runBlocking {
        coEvery { repository.getHighlightedProducts() } returns flowOf(Result.Error(message = "Erro", code = 500))

        val result = useCase().toList()
        assertTrue(result.first() is Result.Error)
        assertEquals("Erro", (result.first() as Result.Error).message)
        assertEquals(500, (result.first() as Result.Error).code)
    }
} 