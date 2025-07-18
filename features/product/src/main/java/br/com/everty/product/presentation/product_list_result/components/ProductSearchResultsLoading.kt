package br.com.everty.product.presentation.product_list_result.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.theme.AppTheme
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing

@Composable
fun ProductSearchResultsLoading() {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppSpacing.base),
        modifier = Modifier.padding(AppSpacing.base)
    ) {
        repeat(6) {
            AppShimmerLoader { brush ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = AppTheme.colors.background,
                            shape = RoundedCornerShape(AppSpacing.small)
                        )
                        .padding(AppSpacing.base)
                ) {
                    Spacer(
                        modifier = Modifier
                            .size(80.dp)
                            .background(brush, RoundedCornerShape(AppSpacing.mini))
                    )
                    Spacer(modifier = Modifier.width(AppSpacing.base))
                    Column(modifier = Modifier.weight(1f)) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(16.dp)
                                .background(brush, RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Spacer(
                            modifier = Modifier
                                .width(60.dp)
                                .height(12.dp)
                                .background(brush, RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Spacer(
                            modifier = Modifier
                                .width(80.dp)
                                .height(10.dp)
                                .background(brush, RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Spacer(
                            modifier = Modifier
                                .width(100.dp)
                                .height(14.dp)
                                .background(brush, RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Spacer(
                            modifier = Modifier
                                .width(60.dp)
                                .height(10.dp)
                                .background(brush, RoundedCornerShape(4.dp))
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(AppSpacing.base))
        }
    }
}

@Preview
@Composable
fun ProductSearchResultsLoadingPreview() {
    AppTheme {
        ProductSearchResultsLoading()
    }
}
