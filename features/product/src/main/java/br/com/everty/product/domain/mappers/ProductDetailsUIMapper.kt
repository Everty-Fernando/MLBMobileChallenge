package br.com.everty.product.domain.mappers

import br.com.everty.product.data.model.ProductResponse
import br.com.everty.product.domain.model.ProductDetailsModelUI
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.shared.utils.mappers.Mapper
import java.text.NumberFormat
import java.util.Locale
import kotlin.random.Random

class ProductDetailsUIMapper: Mapper<ProductResponse, ProductDetailsModelUI> {

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    override fun toObject(fromObject: ProductResponse): ProductDetailsModelUI {
        val (discountedPrice, originalPrice) = generateFakePrices()

        return ProductDetailsModelUI(
            id = fromObject.id,
            imageUrls = fromObject.pictures.map { it.url },
            title = fromObject.name,
            rating = generateRandomRating(), //Todo(procurar endpoint que retorne)
            ratingCount = generateRandomCount(), //Todo(procurar endpoint que retorne)
            originalPrice = originalPrice, //Todo(procurar endpoint que retorne)
            currentPrice = discountedPrice, //Todo(procurar endpoint que retorne)
            hasFreeShipping = hasFreeShipping(fromObject), //Todo(procurar endpoint que retorne)
            sellerName = fromObject.attributes.find { it.id == "BRAND" }?.valueName ?: "",
            stockAvailable = generateRandomStock(), //Todo(procurar endpoint que retorne)
            arrivesTomorrow = generateRandomBoolean(), //Todo(procurar endpoint que retorne)
            hasInstallments = generateRandomBoolean(), //Todo(procurar endpoint que retorne)
            hasWarranty = generateRandomBoolean(), //Todo(procurar endpoint que retorne)
            description = fromObject.shortDescription?.content ?: "",
            features = fromObject.attributes.map { "${it.name}: ${it.valueName}" }
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
        return Random.nextDouble(3.5, 5.0).toFloat()
    }

    private fun generateRandomCount(): Int {
        return Random.nextInt(20, 2000)
    }

    private fun generateRandomStock(): Int {
        return Random.nextInt(1, 101) // 1 a 100
    }

    private fun generateRandomBoolean(): Boolean {
        return Random.nextBoolean()
    }
}

