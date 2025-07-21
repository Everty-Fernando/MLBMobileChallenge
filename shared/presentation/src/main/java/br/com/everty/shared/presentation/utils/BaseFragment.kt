package br.com.everty.shared.presentation.utils

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment {

    constructor() : super()
    constructor(@LayoutRes res: Int) : super(res)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            setupViews()
        }
    }

    abstract fun setupViews()
}