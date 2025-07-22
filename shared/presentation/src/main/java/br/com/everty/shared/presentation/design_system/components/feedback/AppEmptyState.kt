package br.com.everty.shared.presentation.design_system.components.feedback

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.loader.AppLottieAnimation
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AppEmptyState(
    message: String,
    modifier: Modifier = Modifier,
    lottieAsset: String? = null,
    lottieSize: Dp = 260.dp, //Todo(pending refactor),
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (lottieAsset != null) {
                AppLottieAnimation(
                    assetName = lottieAsset,
                    size = lottieSize,
                    iterations = LottieConstants.IterateForever
                )
            }
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = AppTheme.colors.secondaryText
                ),
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun AppEmptyStatePreview() {
    AppTheme {
        AppEmptyState(
            message = "Nenhum resultado encontrado.",
            // lottieAsset = "empty_state.json"
        )
    }
} 