package br.com.everty.shared.presentation.design_system.components.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.everty.shared.presentation.design_system.dimens.AppDimens
import br.com.everty.shared.presentation.design_system.theme.AppTheme

@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.divider,
    thickness: Dp = AppDimens.tiny,
) {
    Box(
        modifier
            .fillMaxWidth()
            .height(thickness)
            .background(color)
    )
}

@Composable
private fun AppDividerPreview() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(8.dp))
        AppDivider()
        Spacer(modifier = Modifier.height(8.dp))
    }
}
