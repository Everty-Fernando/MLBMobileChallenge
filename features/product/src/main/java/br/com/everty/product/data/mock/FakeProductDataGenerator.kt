package br.com.everty.product.data.mock

import java.text.NumberFormat
import java.util.Locale
import kotlin.random.Random

/**
 * FakeProductDataGenerator é responsável por gerar dados mockados temporários
 * para preencher atributos que não estão disponíveis no endpoint real.
 *
 * IMPORTANTE: Substituir pelas informações reais assim que encontrar API que retorna esses dados.
 */
object FakeProductDataGenerator {
    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))


    fun generatePrices(): Pair<String, String> {
        val original = Random.nextDouble(1000.0, 7000.0)
        val discountPercentage = Random.nextDouble(0.1, 0.3)
        val discounted = original * (1 - discountPercentage)

        return Pair(
            currencyFormatter.format(discounted),
            currencyFormatter.format(original)
        )
    }

    fun generateRandomRating(): Float {
        return String.format(Locale.US, "%.2f", Random.nextDouble(3.5, 5.0)).toFloat()
    }

    fun generateRandomCount(): Int {
        return Random.nextInt(20, 2000)
    }

    fun generateRandomStock(): Int {
        return Random.nextInt(1, 101)
    }

    fun generateRandomBoolean(): Boolean {
        return Random.nextBoolean()
    }
}