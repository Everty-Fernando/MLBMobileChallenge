package br.com.everty.product.presentation.product_search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoaderRectangle
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme


@Composable
fun ProductListLoadingContent() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = AppSpacing.base,
            end = AppSpacing.base,
            bottom = AppSpacing.xlarge
        ),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.large),
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.base),
        modifier = Modifier.fillMaxSize()
    ) {
        items(6) {
            AppShimmerLoader { brush ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(AppSpacing.small))
                        .background(AppTheme.colors.background)
                        .padding(AppSpacing.base)
                ) {
                    AppShimmerLoaderRectangle(
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth(),
                        brush = brush
                    )

                    Spacer(modifier = Modifier.height(AppSpacing.base))

                    repeat(2) {
                        AppShimmerLoaderRectangle(
                            modifier = Modifier
                                .fillMaxWidth(if (it == 0) 1f else 0.6f)
                                .height(12.dp),
                            brush = brush
                        )
                        Spacer(modifier = Modifier.height(AppSpacing.tiny))
                    }

                    Spacer(modifier = Modifier.height(AppSpacing.small))

                    AppShimmerLoaderRectangle(
                        modifier = Modifier
                            .width(80.dp)
                            .height(14.dp),
                        brush = brush
                    )
                }
            }
        }
    }
}