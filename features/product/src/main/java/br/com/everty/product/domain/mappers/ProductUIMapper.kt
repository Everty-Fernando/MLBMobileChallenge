package br.com.everty.product.domain.mappers

import br.com.everty.product.data.mock.FakeProductDataGenerator.generatePrices
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomBoolean
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomCount
import br.com.everty.product.data.mock.FakeProductDataGenerator.generateRandomRating
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.shared.utils.mappers.Mapper

/**
 * Obs: Alguns campos abaixo estão sendo preenchidos com dados gerados aleatoriamente
 * porque ainda não localizei os endpoints reais que fornecem essas informações.
 */
class ProductUIMapper : Mapper<ProductResponse, ProductModelUI> {

    override fun toObject(fromObject: ProductResponse): ProductModelUI {
        val (discountedPrice, originalPrice) = generatePrices()

        return ProductModelUI(
            id = fromObject.id,
            imageUrl = fromObject.pictures.firstOrNull()?.url.orEmpty(),
            title = fromObject.name,
            currentPrice = discountedPrice,
            originalPrice = originalPrice,
            rating = generateRandomRating(),
            ratingCount = generateRandomCount(),
            hasFreeShipping = generateRandomBoolean(),
        )
    }
}
