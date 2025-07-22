package br.com.everty.shared.presentation.design_system.components.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun AppLottieAnimation(
    assetName: String,
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    iterations: Int = 1,
    speed: Float = 1.0f,
    onFinished: (() -> Unit)? = null
) {
    var isAnimationFinished by remember { mutableStateOf(false) }
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(assetName))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = iterations,
        speed = speed,
        isPlaying = true
    )
    LaunchedEffect(progress) {
        if (progress == 1f && !isAnimationFinished) {
            isAnimationFinished = true
            delay(300)
            onFinished?.invoke()
        }
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(size),
            speed = speed
        )
    }
} 