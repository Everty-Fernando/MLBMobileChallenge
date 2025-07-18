package br.com.everty.product.presentation.product_list_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.everty.product.presentation.product_list_result.events.ProductResultEvents
import br.com.everty.product.presentation.product_list_result.screen.ProductSearchResultsScreen
import br.com.everty.product.presentation.product_list_result.viewmodel.ProductSearchResultsViewModel
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductSearchResultsFragment : BaseFragment() {

    private val viewModel: ProductSearchResultsViewModel by viewModel()
    private val args: ProductSearchResultsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ProductSearchResultsScreen(state = viewModel.uiState, events = searchEvents)
                }
            }
        }
    }

    private val searchEvents = object : ProductResultEvents {
        override fun onBackClick() {
            findNavController().popBackStack()
        }

        override fun onValueChangeSearch(value: String) {
            viewModel.updateSearchQuery(value)
        }

        override fun onSearchClick(query: String) {
            viewModel.searchProducts(query)
        }
    }

    override fun setupNavigation(view: View) = Unit

    override fun setupViews() {
        viewModel.searchProducts(args.query)
    }

    override fun setupObservers() = Unit

}