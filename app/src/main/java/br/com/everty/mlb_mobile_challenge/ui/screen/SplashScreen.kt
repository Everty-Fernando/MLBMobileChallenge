package br.com.everty.mlb_mobile_challenge.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.loader.AppLottieAnimation
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun SplashScreen(
    onAnimationFinished: () -> Unit = {}
) {
    AppLottieAnimation(
        assetName = "splash_screen.json",
        size = 200.dp,
        iterations = 1,
        onFinished = onAnimationFinished
    )
}

@Composable
@Preview
private fun AppSplash_Preview() {
    AppTheme {
        SplashScreen()
    }
}