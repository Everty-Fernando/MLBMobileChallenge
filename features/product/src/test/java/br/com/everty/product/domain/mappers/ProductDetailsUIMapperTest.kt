package br.com.everty.product.domain.mappers

import br.com.everty.product.data.model.ProductResponse
import br.com.everty.product.data.mock.FakeProductDataGenerator
import br.com.everty.product.data.model.Attribute
import br.com.everty.product.data.model.Picture
import br.com.everty.product.data.model.ShortDescription
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ProductDetailsUIMapperTest {

    @Before
    fun setUp() {
        mockkObject(FakeProductDataGenerator)
        every { FakeProductDataGenerator.generatePrices() } returns Pair("R$ 100,00", "R$ 200,00")
        every { FakeProductDataGenerator.generateRandomRating() } returns 4.5f
        every { FakeProductDataGenerator.generateRandomCount() } returns 123
        every { FakeProductDataGenerator.generateRandomBoolean() } returns true
        every { FakeProductDataGenerator.generateRandomStock() } returns 10
    }

    @After
    fun tearDown() {
        unmockkObject(FakeProductDataGenerator)
    }

    @Test
    fun `toObject maps all fields correctly`() {
        val pictures = listOf(

            Picture(url = "url1"),
            Picture(url = "url2")
        )
        val attributes = listOf(
            Attribute(id = "BRAND", name = "Marca", valueName = "Nike"),
            Attribute(id = "COLOR", name = "Cor", valueName = "Azul")
        )
        val shortDescription = ShortDescription(content = "Descrição do produto")
        val productResponse = ProductResponse(
            id = "123",
            name = "Tênis Esportivo",
            pictures = pictures,
            attributes = attributes,
            mainFeatures = emptyList(),
            permalink = null,
            shortDescription = shortDescription
        )

        val mapper = ProductDetailsUIMapper()
        val result = mapper.toObject(productResponse)

        assertEquals("123", result.id)
        assertEquals(listOf("url1", "url2"), result.imageUrls)
        assertEquals("Tênis Esportivo", result.title)
        assertEquals(4.5f, result.rating, 0.01f)
        assertEquals(123, result.ratingCount)
        assertEquals("R$ 200,00", result.originalPrice)
        assertEquals("R$ 100,00", result.currentPrice)
        assertTrue(result.hasFreeShipping)
        assertEquals("Nike", result.sellerName)
        assertEquals(10, result.stockAvailable)
        assertTrue(result.arrivesTomorrow)
        assertTrue(result.hasInstallments)
        assertTrue(result.hasWarranty)
        assertEquals("Descrição do produto", result.description)
        assertEquals(listOf("Marca: Nike", "Cor: Azul"), result.features)
    }

    @Test
    fun `toObject handles missing optional fields`() {
        val productResponse = ProductResponse(
            id = "456",
            name = "Produto sem detalhes",
            pictures = emptyList(),
            attributes = emptyList(),
            mainFeatures = emptyList(),
            permalink = null,
            shortDescription = null
        )

        val mapper = ProductDetailsUIMapper()
        val result = mapper.toObject(productResponse)

        assertEquals("456", result.id)
        assertTrue(result.imageUrls.isEmpty())
        assertEquals("Produto sem detalhes", result.title)
        assertEquals("", result.sellerName)
        assertEquals("", result.description)
        assertTrue(result.features.isEmpty())
    }
}
