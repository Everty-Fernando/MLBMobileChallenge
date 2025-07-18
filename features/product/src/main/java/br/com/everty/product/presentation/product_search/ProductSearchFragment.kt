package br.com.everty.product.presentation.product_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import br.com.everty.product.presentation.product_search.events.ProductSearchEvents
import br.com.everty.product.presentation.product_search.preview.productUIStatePreview
import br.com.everty.product.presentation.product_search.screen.ProductSearchScreen
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.utils.BaseFragment

class ProductSearchFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ProductSearchScreen(state = productUIStatePreview , events = searchEvents)
                }
            }
        }
    }

    private val searchEvents = object : ProductSearchEvents {
        override fun onValueChangeSearch(value: String) {
        }

        override fun onSearchClick(query: String) {

        }
    }

    override fun setupNavigation(view: View) = Unit

    override fun setupViews() {
    }

    override fun setupObservers() = Unit

}