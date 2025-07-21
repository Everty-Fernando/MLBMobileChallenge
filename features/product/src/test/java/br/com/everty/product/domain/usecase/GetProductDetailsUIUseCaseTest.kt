package br.com.everty.product.domain.usecase

import br.com.everty.product.domain.mappers.ProductDetailsUIMapper
import br.com.everty.product.domain.model.ProductDetailsModelUI
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
class GetProductDetailsUIUseCaseTest {

    private lateinit var repository: ProductRepository
    private lateinit var mapper: ProductDetailsUIMapper
    private lateinit var useCase: GetProductDetailsUIUseCase

    @Before
    fun setUp() {
        repository = mockk()
        mapper = mockk()
        useCase = GetProductDetailsUIUseCase(repository, mapper)
    }

    @Test
    fun `invoke emits Result_Success with mapped details when repository returns success`() = runBlocking {
        val productResponse = mockk<ProductResponse>()
        val productUI = mockk<ProductDetailsModelUI>()
        coEvery { repository.getProductDetails("1") } returns flowOf(Result.Success(productResponse))
        every { mapper.toObject(productResponse) } returns productUI

        val result = useCase("1").toList()
        assertTrue(result.first() is Result.Success)
        assertEquals(productUI, (result.first() as Result.Success).data)
    }

    @Test
    fun `invoke emits Result_Error when repository returns error`() = runBlocking {
        coEvery { repository.getProductDetails("1") } returns flowOf(Result.Error(message = "Erro", code = 404))

        val result = useCase("1").toList()
        assertTrue(result.first() is Result.Error)
        assertEquals("Erro", (result.first() as Result.Error).message)
        assertEquals(404, (result.first() as Result.Error).code)
    }
} 