package br.com.everty.product.presentation.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.everty.product.presentation.product_details.events.ProductDetailsEvents
import br.com.everty.product.presentation.product_details.screen.ProductDetailsScreen
import br.com.everty.product.presentation.product_details.viewmodel.ProductDetailsViewModel
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {

    private val viewModel: ProductDetailsViewModel by viewModel()
    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ProductDetailsScreen(state = viewModel.uiState, events = searchEvents)
                }
            }
        }
    }

    private val searchEvents = object : ProductDetailsEvents {
        override fun onBackClick() {
            findNavController().popBackStack()
        }

        override fun onFavoriteClick() {
            //Todo(pending implementation)
        }

        override fun onShareClick() {
            //Todo(pending implementation)
        }

        override fun onAddCartClick() {
            //Todo(pending implementation)
        }

        override fun onBuyClick() {
            //Todo(pending implementation)
        }

        override fun onRetry() {
            viewModel.getDetailsProduct(args.productId)
        }

    }

    override fun setupViews() {
        viewModel.getDetailsProduct(args.productId)
    }
}