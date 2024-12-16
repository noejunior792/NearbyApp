package dev.noejunior299.nearby.component.market


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.noejunior299.nearby.R
import dev.noejunior299.nearby.data.model.NearbyMarket
import dev.noejunior299.nearby.ui.theme.Gray100
import dev.noejunior299.nearby.ui.theme.Gray200
import dev.noejunior299.nearby.ui.theme.Gray400
import dev.noejunior299.nearby.ui.theme.Gray500
import dev.noejunior299.nearby.ui.theme.RedBase
import dev.noejunior299.nearby.ui.theme.Typography

@Composable
fun NearbyMarketCard(
    modifier: Modifier = Modifier,
    market: NearbyMarket,
    onClick: (NearbyMarket) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray200, RoundedCornerShape(12.dp)),
        onClick = {
            onClick(market)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.img_burger),
                contentDescription = "Imagem da Loja"
            )
            Column {
                Text(text = market.name, style = Typography.headlineSmall.copy(fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = market.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500,
                    style = Typography.bodyLarge.copy(fontSize = 12.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = if (market.coupons > 0) RedBase else Gray400,
                        painter = painterResource(id = R.drawable.ic_ticket),
                        contentDescription = "Ícone do Cupom"
                    )
                    Text(
                        text = "${market.coupons} cupons disponíveis.",
                        color = Gray400,
                        style = Typography.bodyMedium.copy(fontSize = 12.sp)
                    )
                }

            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardPreview() {
    NearbyMarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = NearbyMarket(
            id = "nearby",
            categoryId = "comida",
            name = "Arroz",
            description = "Boa comida",
            coupons = 10,
            rules = emptyList(),
            latitude = -123434.3445555,
            longitude = 123344.455553,
            address = "Luanda, Angola",
            phone = "123456789",
            coverImage = "hello.world"
        ),
        onClick = {}
    )
}

@Preview
@Composable
private fun NearbyMarketCardNoCouponsPreview() {
    NearbyMarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = NearbyMarket(
            id = "nearby",
            categoryId = "comida",
            name = "Arroz",
            description = "Epha até aqui Deus ajudou",
            coupons = 0,
            rules = emptyList(),
            latitude = -123434.3445555,
            longitude = 123344.455553,
            address = "Luanda, Angola",
            phone = "123456789",
            coverImage = "hello.world"
        ),
        onClick = {}
    )
}