package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductDetailsFeatures(
    features: List<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = AppSpacing.base)
    ) {
        Text(
            text = stringResource(R.string.product_details_features),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = AppTheme.colors.onBackground
            )
        )
        Spacer(modifier = Modifier.height(AppDimens.micro))
        features.forEach { feature ->
           Row(
               modifier = Modifier.fillMaxWidth().padding(start = AppSpacing.micro),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = spacedBy(AppSpacing.micro)
           ) {
               Box(
                   modifier = Modifier
                       .size(AppDimens.micro)
                       .clip(CircleShape)
                       .background(AppTheme.colors.highlight)
               )

               Text(
                   text = feature,
                   style = MaterialTheme.typography.bodyMedium.copy(
                       color = AppTheme.colors.onBackground
                   ),
                   modifier = Modifier.weight(1f)
               )
           }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailsFeaturesPreview() {
    ProductDetailsFeatures(
        features = listOf(
            "Tela Super Retina XDR de 6.7 polegadas",
            "Chip A16 Bionic",
            "Câmera de 48MP",
            "Face ID",
            "iOS 16 com novas funções"
        )
    )
}
