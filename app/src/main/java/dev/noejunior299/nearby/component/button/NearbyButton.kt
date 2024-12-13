package dev.noejunior299.nearby.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.noejunior299.nearby.R
import dev.noejunior299.nearby.ui.theme.GreenBase


@Composable
private fun String?.NearbyButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.heightIn(min = 56.dp),
        contentPadding = if (this == null && iconRes != null) PaddingValues(0.dp) else PaddingValues(0.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            iconRes?.let {
                Icon(painter = painterResource(id = iconRes), contentDescription = "Ícone do Botão")
            }
            this@NearbyButton?.let { Text(text = this@NearbyButton) }
        }
    }
}

@Preview
@Composable
private fun NearbyButtonPreview() {
    "Faça o scan".NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        iconRes = R.drawable.ic_scan
    ) {

    }
}