package br.com.everty.product.presentation.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.everty.product.presentation.product_details.events.ProductDetailsEvents
import br.com.everty.product.presentation.product_details.preview.productDetailsUIStatePreview
import br.com.everty.product.presentation.product_details.screen.ProductDetailsScreen
import br.com.everty.product.presentation.product_details.viewmodel.ProductDetailsViewModel
import br.com.everty.product.presentation.product_list_result.events.ProductResultEvents
import br.com.everty.product.presentation.product_list_result.screen.ProductSearchResultsScreen
import br.com.everty.product.presentation.product_list_result.viewmodel.ProductSearchResultsViewModel
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {

    private val viewModel: ProductDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ProductDetailsScreen(state = productDetailsUIStatePreview, events = searchEvents)
                }
            }
        }
    }

    private val searchEvents = object : ProductDetailsEvents {
        override fun onBackClick() {

        }

        override fun onFavoriteClick() {
        }

        override fun onShareClick() {
        }

        override fun onPageImageChanged(pageSelected: Int) {

        }

        override fun onAddCartClick() {
        }

        override fun onBuyClick() {
        }

    }

    override fun setupNavigation(view: View) = Unit

    override fun setupViews() {
    }

    override fun setupObservers() = Unit

}