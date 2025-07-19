package br.com.everty.product.presentation.product_details.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.components.carousel.AppImageCarousel

@Composable
fun ProductDetailsImageCarousel(
    imageUrls: List<String>,
    onPageChanged: (Int) -> Unit
) {
    AppImageCarousel(
        imageUrls = imageUrls,
        modifier = Modifier.fillMaxWidth(),
        onPageChanged = onPageChanged
    )
}

@Preview
@Composable
private fun ProductDetailsImageCarouselPreview() {
    ProductDetailsImageCarousel(
        imageUrls = listOf(
            "https://placehold.co/600x400",
            "https://placehold.co/600x401"
        ),
        onPageChanged = {}
    )
}
