package br.com.everty.product.domain.mappers

import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.data.model.ProductResponse
import br.com.everty.shared.utils.mappers.Mapper
import java.text.NumberFormat
import java.util.Locale
import kotlin.random.Random

class ProductUIMapper : Mapper<ProductResponse, ProductModelUI> {

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    override fun toObject(fromObject: ProductResponse): ProductModelUI {
        val (discountedPrice, originalPrice) = generateFakePrices()

        return ProductModelUI(
            id = fromObject.id,
            imageUrl = fromObject.pictures.firstOrNull()?.url.orEmpty(),
            title = fromObject.name,
            currentPrice = discountedPrice,
            originalPrice = originalPrice,
            rating = generateRandomRating(),
            ratingCount = generateRandomCount(),
            hasFreeShipping = hasFreeShipping(fromObject),
        )
    }

    private fun hasFreeShipping(fromObject: ProductResponse): Boolean {
        return fromObject.mainFeatures.any {
            it.text.contains("frete grátis", ignoreCase = true)
        }
    }

    private fun generateFakePrices(): Pair<String, String> {
        val original = Random.nextDouble(1000.0, 7000.0)
        val discountPercentage = Random.nextDouble(0.1, 0.3)
        val discounted = original * (1 - discountPercentage)

        return Pair(
            currencyFormatter.format(discounted),
            currencyFormatter.format(original)
        )
    }

    private fun generateRandomRating(): Float {
        return String.format(Locale.US, "%.2f", Random.nextDouble(3.5, 5.0)).toFloat()
    }

    private fun generateRandomCount(): Int {
        return Random.nextInt(20, 2000)
    }
}
