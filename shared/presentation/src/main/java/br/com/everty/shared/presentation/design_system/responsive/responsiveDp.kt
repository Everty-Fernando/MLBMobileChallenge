package br.com.everty.shared.presentation.design_system.responsive

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun responsiveDp(percent: Float, basedOn: Dimension = Dimension.Width): Dp {
    val configuration = LocalConfiguration.current
    val screenSize = when (basedOn) {
        Dimension.Width -> configuration.screenWidthDp
        Dimension.Height -> configuration.screenHeightDp
    }
    return (screenSize * percent).dp
}

enum class Dimension {
    Width, Height
}
