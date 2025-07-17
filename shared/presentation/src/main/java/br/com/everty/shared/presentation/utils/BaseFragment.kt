package br.com.everty.shared.presentation.utils

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment {

    constructor() : super()
    constructor(@LayoutRes res: Int) : super(res)

    abstract fun setupNavigation(view: View)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        setupNavigation(view)
    }

    abstract fun setupViews()

    abstract fun setupObservers()
}