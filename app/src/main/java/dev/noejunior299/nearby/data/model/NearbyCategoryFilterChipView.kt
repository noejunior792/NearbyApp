package dev.noejunior299.nearby.data.model

import androidx.annotation.DrawableRes
import dev.noejunior299.nearby.R

enum class NearbyCategoryFilterChipView (
    val description: String,
    @DrawableRes val icon: Int,
){
    ALIMENTACAO(description="Alimentação", icon= R.drawable.ic_tools_kitchen_2),
    COMPRAS(description="Compras", icon= R.drawable.ic_shopping_cart),
    HOSPEDAGEM(description = "HOSPEDAGEM", icon= R.drawable.ic_bed);

    companion object {
        fun fromDescription(
            description: String
        ): NearbyCategoryFilterChipView? {
            return entries.find { it.description == description }
        }
    }
}