package br.com.everty.shared.presentation.utils

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity {

    constructor() : super()
    constructor(@LayoutRes res: Int) : super(res)

}
