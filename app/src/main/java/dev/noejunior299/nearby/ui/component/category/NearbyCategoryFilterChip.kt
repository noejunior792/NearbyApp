package dev.noejunior299.nearby.ui.component.category

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.noejunior299.nearby.data.model.NearbyCategory
import dev.noejunior299.nearby.theme.Gray300
import dev.noejunior299.nearby.theme.Gray400
import dev.noejunior299.nearby.theme.GreenBase
import dev.noejunior299.nearby.theme.Typography

@Composable
fun NearbyCategoryFilterChip(
    modifier: Modifier = Modifier,
    category: NearbyCategory,
    isSelected: Boolean,
    onClick: (isSelected: Boolean) -> Unit
) {
    FilterChip(
        modifier = modifier
            .padding(2.dp)
            .heightIn(min = 36.dp),
        elevation = FilterChipDefaults.filterChipElevation(
            elevation = 8.dp
        ),
        leadingIcon =  {
            category.icon?.let {
                Icon(
                   modifier = Modifier.size(16.dp),
                    painter = painterResource(id = it),
                    tint =  if (isSelected) Color.White else Gray400,
                    contentDescription = "Ícone de Filtro da Categoria"
                )
            }
        },
        border = FilterChipDefaults.filterChipBorder(
          enabled = false,
            selected = isSelected,
            disabledBorderColor = Gray300,
            borderWidth = 1.dp,
            selectedBorderWidth = 0.dp,
            selectedBorderColor = Color.Transparent
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor =  Color.White ,
            selectedContainerColor = GreenBase,
        ),
        selected = isSelected,
        onClick = { onClick(!isSelected) },
        label = {
            Text(
                text = category.name,
                style = Typography.bodyMedium,
                color = if (isSelected) Color.White else Gray400
            )
        }
    )
}

@Preview
@Composable
fun NearbyCategoryFilterChipPreview() {
    NearbyCategoryFilterChip(
   category = NearbyCategory (
       id = "1",
       name = "Alimentação"
   ),
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
fun NearbyCategoryFilterChipNoSelectPreview() {
    NearbyCategoryFilterChip(
        category = NearbyCategory (
            id = "1",
            name = "Cinema"
        ),
        isSelected = false,
        onClick = {}
    )
}