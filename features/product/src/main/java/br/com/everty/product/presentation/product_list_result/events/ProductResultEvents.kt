package br.com.everty.product.presentation.product_list_result.events

import br.com.everty.product.presentation.product_search.events.ProductSearchEvents

interface ProductResultEvents: ProductSearchEvents {
    fun onBackClick()
}