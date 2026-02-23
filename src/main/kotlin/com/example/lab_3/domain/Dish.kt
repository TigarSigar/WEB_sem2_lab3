package com.example.lab_3.domain

import java.math.BigDecimal

data class Dish(
    val id: Long = 0,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val isAvailable: Boolean
)