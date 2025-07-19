package br.com.everty.product.presentation.product_details.preview

import br.com.everty.product.domain.model.ProductDetailsModelUI
import br.com.everty.product.presentation.product_details.state.ProductDetailsUIState

val productDetailsMock = ProductDetailsModelUI(
    id = "",
    imageUrls = listOf(
        "https://placehold.co/600x400",
        "https://placehold.co/600x400",
        "https://placehold.co/600x400"
    ),
    isNew = true,
    isFavorite = false,
    title = "iPhone 14 Pro Max 128GB - Deep Purple",
    rating = 4.8f,
    ratingCount = 1247,
    currentPrice = "R$ 4.299,99",
    originalPrice = "R$ 4.799,99",
    hasFreeShipping = true,
    sellerName = "TechStore Oficial",
    sellerLink = "",
    stockAvailable = 15,
    benefits = listOf(
        "Chega grátis amanhã",
        "Pague em até 12x sem juros",
        "Garantia oficial de 1 ano"
    ),
    description = "O iPhone 14 Pro Max conta com o chip A16 Bionic, sistema de câmera Pro avançado com câmera principal de 48MP, tela Super Retina XDR de 6.7 polegadas com ProMotion, e até 29 horas de reprodução de vídeo.",
    features = listOf(
        "Tela Super Retina XDR de 6.7 polegadas",
        "Chip A16 Bionic",
        "Sistema de câmera Pro com câmera principal de 48MP",
        "Até 29 horas de reprodução de vídeo",
        "Face ID para autenticação segura",
        "iOS 16 com novas funções de personalização"
    )
)

val productDetailsUIStatePreview = ProductDetailsUIState(
    productDetails = productDetailsMock
)
