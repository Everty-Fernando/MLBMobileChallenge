package br.com.everty.product.presentation.product_list_result.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.domain.usecase.GetProductSearchListUIUseCase
import br.com.everty.product.presentation.product_search.state.ProductUIState
import br.com.everty.shared.utils.Result
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ProductSearchResultsViewModel(
    private val getProductSearchListUIUseCase: GetProductSearchListUIUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ProductUIState())
        private set

    fun searchProducts(query: String) = viewModelScope.launch {
        updateSearchQuery(query)
        getProductSearchListUIUseCase(query)
            .onStart { handleLoading() }
            .collect { result ->
                when (result) {
                    is Result.Success -> handleSuccess(result.data)
                    is Result.Error -> handleError(result)
                }
            }
    }

    private fun handleLoading() {
        uiState = uiState.copy(
            isLoading = true,
            errorMessage = null,
        )
    }

    private fun handleSuccess(productList: List<ProductModelUI>) {
        uiState = uiState.copy(
            productList = productList,
            isLoading = false
        )
    }

    private fun handleError(result: Result.Error) {
        uiState = uiState.copy(
            isLoading = false,
            errorMessage = result.message,
            showRetry = result.showRetry
        )
    }

    fun updateSearchQuery(newValue: String) {
        uiState = uiState.copy(inputQuery = newValue.filter { it.isLetterOrDigit() || it.isWhitespace() })
    }
} 