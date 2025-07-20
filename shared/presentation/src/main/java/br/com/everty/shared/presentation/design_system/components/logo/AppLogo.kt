package br.com.everty.shared.presentation.design_system.components.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.R
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppLogo(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
       Image(
           modifier = Modifier.size(72.dp),
           painter = painterResource(R.drawable.meli_logo),
           contentDescription = "Logo meli"
       )
    }
}

@Preview
@Composable
private fun AppLogoPreview() {
    AppTheme {
        AppLogo()
    }
}

