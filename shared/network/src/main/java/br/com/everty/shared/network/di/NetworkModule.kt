package br.com.everty.shared.network.di


import br.com.everty.shared.network.ApiClient
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


fun injectNetworkModule() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(module))
}

private val module = module {
    factory { ApiClient() }

}
