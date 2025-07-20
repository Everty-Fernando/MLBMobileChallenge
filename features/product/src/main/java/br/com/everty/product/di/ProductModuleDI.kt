package br.com.everty.product.di

import br.com.everty.product.data.api.ProductAPI
import br.com.everty.product.domain.mappers.ProductDetailsUIMapper
import br.com.everty.product.domain.mappers.ProductUIMapper
import br.com.everty.product.domain.usecase.GetProductDetailsUIUseCase
import br.com.everty.product.domain.usecase.GetProductListUIUseCase
import br.com.everty.product.domain.usecase.GetProductSearchListUIUseCase
import br.com.everty.product.presentation.product_details.viewmodel.ProductDetailsViewModel
import br.com.everty.product.presentation.product_list_result.viewmodel.ProductResultsViewModel
import br.com.everty.product.presentation.product_search.viewmodel.ProductViewModel
import br.com.everty.product.repository.ProductRepository
import br.com.everty.product.repository.ProductRepositoryImpl
import br.com.everty.shared.network.ApiClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.loadKoinModules
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.bind

fun injectProductModules() = loadProductFeature

private val loadProductFeature by lazy {
    loadKoinModules(
        listOf(
            uiModule,
            domainModule,
            repositoryModule,
            dataModule
        )
    )
}

// UI Layer
private val uiModule = module {
    viewModelOf(::ProductViewModel)
    viewModelOf(::ProductResultsViewModel)
    viewModelOf(::ProductDetailsViewModel)
}

// Domain Layer
private val domainModule = module {
    factoryOf(::GetProductListUIUseCase)
    factoryOf(::GetProductSearchListUIUseCase)
    factoryOf(::GetProductDetailsUIUseCase)

    factoryOf(::ProductUIMapper)
    factoryOf(::ProductDetailsUIMapper)
}

// Repository Layer
private val repositoryModule = module {
    singleOf(::ProductRepositoryImpl) bind ProductRepository::class
}

// Data Layer
private val dataModule = module {
    single { ApiClient().client.create(ProductAPI::class.java)}
}
