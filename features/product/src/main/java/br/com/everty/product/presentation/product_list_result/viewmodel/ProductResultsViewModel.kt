package br.com.everty.product.presentation.product_list_result.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.domain.usecase.GetProductSearchListUIUseCase
import br.com.everty.product.presentation.product_list_result.state.ProductResultsUIState
import br.com.everty.shared.utils.Result
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ProductResultsViewModel(
    private val getProductSearchListUIUseCase: GetProductSearchListUIUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ProductResultsUIState())
        private set

    fun searchProducts(query: String) = viewModelScope.launch {
        getProductSearchListUIUseCase(query)
            .onStart { handleLoading() }
            .collect { result ->
                when (result) {
                    is Result.Success -> handleSuccess(searchedText = query, productList = result.data)
                    is Result.Error -> handleError(result)
                }
            }
    }

    fun updateSearchQuery(newValue: String) {
        uiState = uiState.copy(inputQuery = newValue.filter { it.isLetterOrDigit() || it.isWhitespace() })
    }

    private fun handleLoading() {
        uiState = uiState.copy(
            isLoading = true,
            errorMessage = "",
            errorCode = ""
        )
    }

    private fun handleSuccess(searchedText: String, productList: List<ProductModelUI>) {
        uiState = uiState.copy(
            productList = productList,
            searchedText = searchedText,
            isLoading = false
        )
    }

    private fun handleError(result: Result.Error) {
        uiState = uiState.copy(
            isLoading = false,
            errorMessage = result.message,
            errorCode = result.code?.toString(),
            showRetry = result.showRetry
        )
    }
} 