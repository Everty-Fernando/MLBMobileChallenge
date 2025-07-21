package br.com.everty.shared.presentation.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import br.com.everty.shared.presentation.design_system.color.AppColors
import br.com.everty.shared.presentation.design_system.color.AppDarkColors
import br.com.everty.shared.presentation.design_system.color.AppLightColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = AppDarkColors

private val LightColorScheme = AppLightColors

val localAppThemeComposition = compositionLocalOf {
    LightColorScheme
}

object AppTheme {
    val colors: AppColors
        @Composable get() = localAppThemeComposition.current
    val typography: Typography
        @Composable get() = AppTypography
    val shapes: Shapes
        @Composable get() = AppShapes
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) AppDarkColors else AppLightColors
    val colorScheme = if (darkTheme) DarkAppColorScheme else LightAppColorScheme
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = colors.highlight,
            darkIcons = false
        )
    }

    CompositionLocalProvider(localAppThemeComposition provides colors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

