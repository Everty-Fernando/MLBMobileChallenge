package br.com.everty.product.domain.mappers

import br.com.everty.product.data.mock.FakeProductDataGenerator.generatePrices
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomBoolean
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomCount
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomRating
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomStock
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.product.domain.model.ProductDetailsModelUI
import br.com.everty.shared.utils.mappers.Mapper

/**
 * Obs: Alguns campos abaixo estão sendo preenchidos com dados gerados aleatoriamente
 * porque ainda não localizei os endpoints reais que fornecem essas informações.
 */
class ProductDetailsUIMapper: Mapper<ProductResponse, ProductDetailsModelUI> {

    override fun toObject(fromObject: ProductResponse): ProductDetailsModelUI {
        val (discountedPrice, originalPrice) = generatePrices()

        return ProductDetailsModelUI(
            id = fromObject.id,
            imageUrls = fromObject.pictures.map { it.url },
            title = fromObject.name,
            rating = generateRandomRating(),
            ratingCount = generateRandomCount(),
            originalPrice = originalPrice,
            currentPrice = discountedPrice,
            hasFreeShipping = generateRandomBoolean(),
            sellerName = fromObject.attributes.find { it.id == "BRAND" }?.valueName ?: "",
            stockAvailable = generateRandomStock(),
            arrivesTomorrow = generateRandomBoolean(),
            hasInstallments = generateRandomBoolean(),
            hasWarranty = generateRandomBoolean(),
            description = fromObject.shortDescription?.content ?: "",
            features = fromObject.attributes.map { "${it.name}: ${it.valueName}" }
        )
    }
}

