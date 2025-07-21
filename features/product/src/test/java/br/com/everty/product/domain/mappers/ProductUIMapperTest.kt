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

class ProductUIMapperTest {

    @Before
    fun setUp() {
        mockkObject(FakeProductDataGenerator)
        every { FakeProductDataGenerator.generatePrices() } returns Pair("R$ 100,00", "R$ 200,00")
        every { FakeProductDataGenerator.generateRandomRating() } returns 4.7f
        every { FakeProductDataGenerator.generateRandomCount() } returns 321
        every { FakeProductDataGenerator.generateRandomBoolean() } returns false
    }

    @After
    fun tearDown() {
        unmockkObject(FakeProductDataGenerator)
    }

    @Test
    fun `toObject maps all fields correctly`() {
        val pictures = listOf(
            Picture(url = "img1"),
            Picture(url = "img2")
        )
        val attributes = listOf(
            Attribute(id = "BRAND", name = "Marca", valueName = "Adidas"),
            Attribute(id = "COLOR", name = "Cor", valueName = "Preto")
        )
        val shortDescription = ShortDescription(content = "Descrição curta")
        val productResponse = ProductResponse(
            id = "789",
            name = "Camiseta Esportiva",
            pictures = pictures,
            attributes = attributes,
            mainFeatures = emptyList(),
            permalink = null,
            shortDescription = shortDescription
        )

        val mapper = ProductUIMapper()
        val result = mapper.toObject(productResponse)

        assertEquals("789", result.id)
        assertEquals("img1", result.imageUrl)
        assertEquals("Camiseta Esportiva", result.title)
        assertEquals("R$ 100,00", result.currentPrice)
        assertEquals("R$ 200,00", result.originalPrice)
        assertEquals(4.7f, result.rating, 0.01f)
        assertEquals(321, result.ratingCount)
        assertFalse(result.hasFreeShipping)
    }

    @Test
    fun `toObject handles missing optional fields`() {
        val productResponse = ProductResponse(
            id = "101",
            name = "Produto simples",
            pictures = emptyList(),
            attributes = emptyList(),
            mainFeatures = emptyList(),
            permalink = null,
            shortDescription = null
        )

        val mapper = ProductUIMapper()
        val result = mapper.toObject(productResponse)

        assertEquals("101", result.id)
        assertEquals("", result.imageUrl)
        assertEquals("Produto simples", result.title)
        assertEquals("R$ 100,00", result.currentPrice)
        assertEquals("R$ 200,00", result.originalPrice)
        assertEquals(4.7f, result.rating, 0.01f)
        assertEquals(321, result.ratingCount)
        assertFalse(result.hasFreeShipping)
    }
} 