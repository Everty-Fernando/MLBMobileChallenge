package br.com.everty.shared.presentation.design_system.components.carousel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import br.com.everty.shared.presentation.design_system.components.page_indicator.AppPageIndicator
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppImageCarousel(
    imageUrls: List<String>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { imageUrls.size }
    )

    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) { page ->
            AsyncImage(
                model = imageUrls[page],
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(AppTheme.shapes.medium)
            )
        }

        Spacer(modifier = Modifier.height(AppDimens.xSmall))

        if (imageUrls.size > 1) {
            AppPageIndicator(
                totalDots = imageUrls.size,
                selectedIndex = pagerState.currentPage,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun AppImageCarouselPreview() {
    AppTheme {
        val imageUrls = listOf(
            "https://example.com/image1.jpg",
            "https://example.com/image2.jpg",
            "https://example.com/image3.jpg"
        )


        AppImageCarousel(
            imageUrls = imageUrls,
        )
    }
}
