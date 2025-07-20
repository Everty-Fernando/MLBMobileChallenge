package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoader
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoaderRectangle
import br.com.everty.shared.presentation.design_system.components.loader.AppShimmerLoaderTwoLines
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing


@Composable
fun ProductDetailsLoading() {
    AppShimmerLoader { brush ->

        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Imagem principal
                AppShimmerLoaderRectangle(
                    brush = brush,
                    rectangleSize = 300.dp
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Indicadores de página
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(brush)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Spacer(modifier = Modifier.height(12.dp))

                // Título
                AppShimmerLoaderTwoLines(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    brush = brush,
                    firstLineHeight = 24.dp,
                    secondLineHeight = 24.dp,
                    firstLineWidth = 320.dp,
                    secondLineWidth = 240.dp
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Avaliação
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(120.dp)
                        .height(16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Preços
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(140.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(brush)
                    )
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(18.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(brush)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // "Frete grátis"
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(100.dp)
                        .height(16.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Vendedor e estoque
                repeat(2) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                            .fillMaxWidth(0.6f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(brush)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Benefícios
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                            .fillMaxWidth(0.5f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(brush)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Descrição
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(100.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(8.dp))
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                            .fillMaxWidth(0.8f)
                            .height(14.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(brush)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Características principais
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(200.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(8.dp))
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                            .fillMaxWidth(0.9f)
                            .height(14.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(brush)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(AppSpacing.regular)
                    .align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(brush)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsLoadingPreview() {
    ProductDetailsLoading()
}

