package br.com.everty.shared.presentation.design_system.components.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.R
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppLogo(
    sizeLogo: Dp = 72.dp,
    imgLogo: Int = R.drawable.meli_logo,
) {
    Image(
        modifier = Modifier.height(sizeLogo),
        painter = painterResource(imgLogo),
        contentDescription = "Logo app"
    )
}

@Preview
@Composable
private fun AppLogoPreview() {
    AppTheme {
        AppLogo()
    }
}

