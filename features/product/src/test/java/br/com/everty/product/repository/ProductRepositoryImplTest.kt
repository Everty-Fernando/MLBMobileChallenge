package br.com.everty.product.repository

import br.com.everty.product.data.api.ProductAPI
import br.com.everty.product.data.model.HighlightProductResponse
import br.com.everty.product.data.model.HighlightedProductsResponse
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.shared.utils.Result
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Response
import timber.log.Timber

@ExperimentalCoroutinesApi
class ProductRepositoryImplTest {
    private val api: ProductAPI = mockk()
    private val repository: ProductRepository = ProductRepositoryImpl(api)

    @Test
    fun `getHighlightedProducts returns empty list when highlights is empty`() = runBlocking {
        coEvery { api.getProductsHighlightsList() } returns Response.success(
            HighlightedProductsResponse(content = emptyList())
        )

        val result = repository.getHighlightedProducts().first()
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `getHighlightedProducts returns all products when all details succeed`() = runBlocking {
        val ids = listOf("1", "2", "3", "4", "5", "6")
        val highlightsResponse = HighlightedProductsResponse(
            content = ids.map { mockk<HighlightProductResponse> { every { id } returns it } }
        )
        val products = ids.map { mockk<ProductResponse>() }

        coEvery { api.getProductsHighlightsList() } returns Response.success(highlightsResponse)
        ids.forEachIndexed { i, id ->
            coEvery { api.getProductById(id) } returns Response.success(products[i])
        }

        val result = repository.getHighlightedProducts().first()
        assertTrue(result is Result.Success)
        assertEquals(products, (result as Result.Success).data)
    }

    @Test
    fun `getHighlightedProducts returns partial products and logs when some details fail`() = runBlocking {
        mockkObject(Timber)
        val ids = listOf("1", "2", "3")
        val highlightsResponse = HighlightedProductsResponse(
            content = ids.map { mockk<HighlightProductResponse> { every { id } returns it } }
        )
        val product1 = mockk<ProductResponse>()
        val product3 = mockk<ProductResponse>()

        coEvery { api.getProductsHighlightsList() } returns Response.success(highlightsResponse)
        coEvery { api.getProductById("1") } returns Response.success(product1)
        coEvery { api.getProductById("2") } returns Response.error(404, "".toResponseBody())
        coEvery { api.getProductById("3") } returns Response.success(product3)
        every { Timber.w(any<String>()) } just Runs
        every { Timber.i(any<String>()) } just Runs

        val result = repository.getHighlightedProducts().first()
        assertTrue(result is Result.Success)
        assertEquals(listOf(product1, product3), (result as Result.Success).data)
        verify { Timber.w(match<String> { it.contains("Falha ao carregar produto com ID: 2") }) }
        verify { Timber.i(match<String> { it.contains("Produtos ignorados: 1") }) }
        unmockkObject(Timber)
    }

    @Test
    fun `getHighlightedProducts returns error when highlights call fails`() = runBlocking {
        coEvery { api.getProductsHighlightsList() } returns Response.error(500, "".toResponseBody())

        val result = repository.getHighlightedProducts().first()
        assertTrue(result is Result.Error)
    }

    @Test
    fun `searchProducts returns success when API call is successful`() = runBlocking {
        val products = listOf(mockk<ProductResponse>())
        coEvery { api.searchProducts(query = "abc") } returns Response.success(
            br.com.everty.product.data.model.ProductModelResponse(productsResult = products)
        )

        val result = repository.searchProducts("abc").first()
        assertTrue(result is Result.Success)
        assertEquals(products, (result as Result.Success).data)
    }

    @Test
    fun `searchProducts returns error when API call fails`() = runBlocking {
        coEvery { api.searchProducts(query = "abc") } returns Response.error(404, "".toResponseBody())

        val result = repository.searchProducts("abc").first()
        assertTrue(result is Result.Error)
    }

    @Test
    fun `getProductDetails returns success when API call is successful`() = runBlocking {
        val product = mockk<ProductResponse>()
        coEvery { api.getProductById("1") } returns Response.success(product)

        val result = repository.getProductDetails("1").first()
        assertTrue(result is Result.Success)
        assertEquals(product, (result as Result.Success).data)
    }

    @Test
    fun `getProductDetails returns error when API call fails`() = runBlocking {
        coEvery { api.getProductById("1") } returns Response.error(404, "".toResponseBody())

        val result = repository.getProductDetails("1").first()
        assertTrue(result is Result.Error)
    }
} 