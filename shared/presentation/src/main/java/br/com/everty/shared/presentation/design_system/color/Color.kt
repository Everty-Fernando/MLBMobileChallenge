package br.com.everty.shared.presentation.design_system.color

import androidx.compose.ui.graphics.Color

val AppLightColors = AppColors(
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF212529), // texto primário
    primary = Color(0xFF000000), // pode ser usado nos ícones principais
    primaryVariant = Color(0xFF343A40), // texto escuro alternativo
    secondaryText = Color(0xFF6C757D), // texto cinza
    divider = Color(0xFFE0E0E0), // linhas finas
    highlight = Color(0xFFFFE600), // amarelo destaque
    success = Color(0xFF03B12B), // verde
    error = Color(0xFFEC1C40) // vermelho padrão
)

val AppDarkColors = AppColors(
    background = Color(0xFFFFFFFF), // fundo
    onBackground = Color(0xFF212529), // texto primário
    primary = Color(0xFF000000), // pode ser usado nos ícones principais
    primaryVariant = Color(0xFF343A40), // texto escuro alternativo
    secondaryText = Color(0xFF6C757D), // texto cinza
    divider = Color(0xFFE0E0E0), // linhas finas
    highlight = Color(0xFFFFE600), // amarelo destaque
    success = Color(0xFF03B12B), // verde
    error = Color(0xFFEC1C40) // vermelho padrão
)