package br.com.everty.shared.presentation.design_system.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import br.com.everty.shared.presentation.design_system.color.AppLightColors

val LightAppColorScheme: ColorScheme = lightColorScheme(
    primary = AppLightColors.primary,
    onPrimary = AppLightColors.onBackground,
    background = AppLightColors.background,
    onBackground = AppLightColors.onBackground,
    surface = AppLightColors.background,
    onSurface = AppLightColors.onBackground,
    secondary = AppLightColors.highlight,
    onSecondary = AppLightColors.onBackground,
    error = AppLightColors.error,
    onError = AppLightColors.onBackground,
    primaryContainer = AppLightColors.primaryVariant,
    surfaceVariant = AppLightColors.divider,
    secondaryContainer = AppLightColors.secondaryText,
    tertiary = AppLightColors.success
)

val DarkAppColorScheme: ColorScheme = lightColorScheme(
    primary = AppLightColors.primary,
    onPrimary = AppLightColors.onBackground,
    background = AppLightColors.background,
    onBackground = AppLightColors.onBackground,
    surface = AppLightColors.background,
    onSurface = AppLightColors.onBackground,
    secondary = AppLightColors.highlight,
    onSecondary = AppLightColors.onBackground,
    error = AppLightColors.error,
    onError = AppLightColors.onBackground,
    primaryContainer = AppLightColors.primaryVariant,
    surfaceVariant = AppLightColors.divider,
    secondaryContainer = AppLightColors.secondaryText,
    tertiary = AppLightColors.success
)

