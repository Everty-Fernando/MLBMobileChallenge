package br.com.everty.shared.presentation.design_system.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.button.AppActionButton
import br.com.everty.shared.presentation.design_system.components.loader.AppLottieAnimation
import com.airbnb.lottie.compose.LottieConstants

@Composable
fun AppErrorState(
    modifier: Modifier = Modifier,
    lottieAsset: String = "error_state.json",
    lottieSize: Dp = 300.dp,
    code: String,
    message: String,
    showRetry: Boolean = false,
    retryText: String = "Tentar novamente",
    onRetry: (() -> Unit)? = null
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            AppLottieAnimation(
                assetName = lottieAsset,
                size = lottieSize,
                iterations = LottieConstants.IterateForever
            )
            Text(
                text = code,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp).offset(y = (-50).dp)
            )
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp).offset(y = (-50).dp)
            )
            if (showRetry && onRetry != null) {
                AppActionButton(text = retryText, onClick = onRetry)
            }
        }
    }
} 