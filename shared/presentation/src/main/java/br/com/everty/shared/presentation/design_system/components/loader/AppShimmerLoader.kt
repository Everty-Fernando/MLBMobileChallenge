package br.com.everty.shared.presentation.design_system.components.loader

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppShimmerLoader(shimmerItem: @Composable (Brush) -> Unit) {
    val shimmerColorShades = listOf(
        AppTheme.colors.divider.copy(0.5f),
        AppTheme.colors.divider.copy(0.2f),
        AppTheme.colors.divider.copy(0.5f),
    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim by transition.animateFloat(
        initialValue = 0f, targetValue = 1000f, animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200, easing = FastOutSlowInEasing), RepeatMode.Reverse
        ), label = ""
    )


    val brush = Brush.linearGradient(
        colors = shimmerColorShades, start = Offset(10f, 10f), end = Offset(translateAnim, translateAnim)
    )

    shimmerItem(brush)

}

@Composable
fun AppShimmerLoaderTwoLines(
    modifier: Modifier = Modifier,
    brush: Brush, firstLineWidth: Dp = 400.dp, secondLineWidth: Dp = 400.dp,
    firstLineHeight: Dp = 40.dp,
    secondLineHeight: Dp = 40.dp,
) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(firstLineWidth)
                .clip(RoundedCornerShape(10.dp))
                .height(firstLineHeight)
                .background(brush = brush)
        )

        Spacer(Modifier.height(AppSpacing.small))

        Box(
            modifier = Modifier
                .width(secondLineWidth)
                .clip(RoundedCornerShape(10.dp))
                .height(secondLineHeight)
                .background(brush = brush)
        )
    }
}


@Composable
fun AppShimmerLoaderRectangle(
    modifier: Modifier = Modifier,
    corner: Dp = AppSpacing.mini_plus,
    brush: Brush,
    rectangleSize: Dp = 250.dp,
) {
    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(corner))
                .size(rectangleSize)
                .background(brush = brush)
        )
    }
}


@Composable
fun AppShimmerLoaderCircle(
    modifier: Modifier = Modifier,
    brush: Brush,
    circleSize: Dp = 60.dp,
) {
    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .size(circleSize)
                .background(brush = brush)
        )
    }
}



@Composable
fun AppShimmerLoaderWithBottomSpacer(brush: Brush, rectangleSize: Dp = 250.dp) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .size(rectangleSize)
                .background(brush = brush)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .height(30.dp)
                .padding(vertical = 8.dp)
                .background(brush = brush)
        )
    }
}
