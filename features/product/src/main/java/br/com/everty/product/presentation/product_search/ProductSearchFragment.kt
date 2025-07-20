package br.com.everty.product.presentation.product_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.everty.product.presentation.product_search.events.ProductSearchEvents
import br.com.everty.product.presentation.product_search.screen.ProductSearchScreen
import br.com.everty.product.presentation.product_search.viewmodel.ProductViewModel
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductSearchFragment : BaseFragment() {

    private val viewModel: ProductViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ProductSearchScreen(state = viewModel.uiState, events = searchEvents)
                }
            }
        }
    }

    private val searchEvents = object : ProductSearchEvents {
        override fun onValueChangeSearch(value: String) {
            viewModel.updateSearchQuery(value)
        }

        override fun onSearchClick(query: String) {
            viewModel.clearSearchQuery()
            navigateToProductSearch(query)
        }

        override fun onProductDetailsClick(productId: String) {
            navigateToProductDetails(productId)
        }

        override fun onRetry() {
            viewModel.loadProductList()
        }
    }

    private fun navigateToProductSearch(query: String) {
        val action = ProductSearchFragmentDirections.actionProductSearchFragmentToProductListResultsFragment(query)
        findNavController().navigate(action)
    }

    private fun navigateToProductDetails(productId: String) {
        val action = ProductSearchFragmentDirections.actionProductSearchFragmentToProductDetailsFragment(productId)
        findNavController().navigate(action)
    }

    override fun setupNavigation(view: View) = Unit

    override fun setupViews() {
        viewModel.loadProductList()
    }

    override fun setupObservers() = Unit

}