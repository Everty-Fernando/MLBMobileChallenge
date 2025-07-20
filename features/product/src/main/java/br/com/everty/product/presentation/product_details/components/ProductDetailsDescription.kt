package br.com.everty.product.presentation.product_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.everty.product.R
import br.com.everty.shared.presentation.design_system.spacing.AppSpacing
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun ProductDetailsDescription(description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = AppSpacing.base)
    ) {
        Text(
            text = stringResource(R.string.product_details_description),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = AppTheme.colors.onBackground
            )
        )
        
        Spacer(modifier = Modifier.height(AppSpacing.small))
        
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = AppTheme.colors.onBackground
            )
        )
    }
}

@Preview
@Composable
fun ProductDetailsDescriptionPreview() {
    ProductDetailsDescription(
        description = "O iPhone 14 Pro Max conta com o chip A16 Bionic, câmera de 48MP, tela XDR de 6.7 polegadas e até 29h de reprodução de vídeo."
    )
}
