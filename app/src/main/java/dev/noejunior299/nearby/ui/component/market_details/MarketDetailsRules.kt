package dev.noejunior299.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.noejunior299.nearby.data.model.NearbyRule
import dev.noejunior299.nearby.data.model.mock.mockRules
import dev.noejunior299.nearby.ui.theme.Gray400
import dev.noejunior299.nearby.ui.theme.Gray500
import dev.noejunior299.nearby.ui.theme.Typography

@Composable
fun MarketDetailsRules(
    modifier: Modifier = Modifier,
    rules: List<NearbyRule>
) {
Column (
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(16.dp)
){
    Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

    Text(
        modifier = Modifier.padding(16.dp),
        text = rules.joinToString(separator = " \n", transform = {". ${it.description}"}),
        style = Typography.labelMedium,
        lineHeight = 24.sp,
        color = Gray500
    )
}
}

@Preview
@Composable
private fun MarketDetailsRulesPreview() {
    MarketDetailsRules(
        modifier = Modifier.fillMaxWidth(),
        rules = mockRules
    )
}