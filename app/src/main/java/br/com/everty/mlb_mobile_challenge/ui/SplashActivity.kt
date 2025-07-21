package br.com.everty.mlb_mobile_challenge.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.everty.mlb_mobile_challenge.ui.screen.SplashScreen
import br.com.everty.product.presentation.ProductActivity
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.utils.BaseActivity

class SplashActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SplashScreen(
                        onAnimationFinished = {
                            redirect()
                        }
                    )
                }
            }
        }
    }

    private fun redirect() {
        startActivity(Intent(this, ProductActivity::class.java))
        finish()
    }
}