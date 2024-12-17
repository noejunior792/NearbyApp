package dev.noejunior299.nearby.data.model.mock

import dev.noejunior299.nearby.data.model.NearbyMarket

val mockMarkets = listOf(
    NearbyMarket(
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
    NearbyMarket(
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
    )
)