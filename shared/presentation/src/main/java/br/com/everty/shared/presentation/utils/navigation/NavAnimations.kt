package br.com.everty.shared.presentation.utils.navigation

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import br.com.everty.shared.presentation.R

fun defaultNavOptions(): NavOptions {
    return navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }
}
