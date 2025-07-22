package br.com.everty.mlb_mobile_challenge.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.R
import br.com.everty.shared.presentation.design_system.components.logo.AppLogo
import br.com.everty.shared.presentation.design_system.responsive.responsiveDp
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onAnimationFinished: () -> Unit = {}
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
        delay(1000)
        onAnimationFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.highlight),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000)),
        ) {
            AppLogo(
                sizeLogo = responsiveDp(0.5f),
                imgLogo = R.drawable.logo_mercado_livre
            )
        }
    }
}

@Composable
@Preview
private fun AppSplash_Preview() {
    AppTheme {
        SplashScreen()
    }
}