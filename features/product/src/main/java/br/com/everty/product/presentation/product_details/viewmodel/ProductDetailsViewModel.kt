package br.com.everty.product.presentation.product_details.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.everty.product.domain.model.ProductDetailsModelUI
import br.com.everty.product.domain.model.ProductModelUI
import br.com.everty.product.domain.usecase.GetProductSearchListUIUseCase
import br.com.everty.product.presentation.product_details.state.ProductDetailsUIState
import br.com.everty.product.presentation.product_search.state.ProductUIState
import br.com.everty.shared.utils.Result
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val getProductSearchListUIUseCase: GetProductSearchListUIUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ProductDetailsUIState())
        private set

    fun getDetailsProduct(productId: String) = viewModelScope.launch {

    }

    private fun handleLoading() {
        uiState = uiState.copy(
            isLoading = true,
            errorMessage = null,
        )
    }

    private fun handleSuccess(productDetails: ProductDetailsModelUI) {
        uiState = uiState.copy(
            productDetails = productDetails,
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
} 