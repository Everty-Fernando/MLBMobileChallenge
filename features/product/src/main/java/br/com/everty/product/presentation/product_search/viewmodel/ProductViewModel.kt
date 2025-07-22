package br.com.everty.product.presentation.product_search.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.domain.usecase.GetProductListUIUseCase
import br.com.everty.product.presentation.product_search.state.ProductUIState
import br.com.everty.shared.utils.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductListUIUseCase: GetProductListUIUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ProductUIState())
        private set

    fun loadProductList() = viewModelScope.launch {
        getProductListUIUseCase()
            .onStart { handleLoading() }
            .collect { result ->
                when (result) {
                    is Result.Success -> handleSuccess(result.data)
                    is Result.Error -> handleError(result)
                }
            }
    }

    fun updateSearchQuery(newValue: String) {
        uiState = uiState.copy(inputQuery = newValue.filter { it.isLetterOrDigit() || it.isWhitespace() })
    }

    fun clearSearchState() = viewModelScope.launch {
        delay(200)
        uiState = uiState.copy(inputQuery = "", isSearching = false)
    }

    fun startSearch() {
        uiState = uiState.copy(isSearching = true)
    }

    fun closeSearch() {
        uiState = uiState.copy(isSearching = false)
    }

    private fun handleLoading() {
        uiState = uiState.copy(
            isLoading = true,
            errorMessage = "",
            errorCode = "",
        )
    }

    private fun handleSuccess(products: List<ProductModelUI>) {
        uiState = uiState.copy(
            productList = products,
            isLoading = false
        )
    }

    private fun handleError(result: Result.Error) {
        uiState = uiState.copy(
            isLoading = false,
            errorMessage = result.message,
            errorCode = result.code.toString(),
            showRetry = result.showRetry
        )
    }
}

