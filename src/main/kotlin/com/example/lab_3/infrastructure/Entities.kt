package com.example.lab_3.infrastructure

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "users")
open class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var email: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var isActive: Boolean = true
)

@Entity
@Table(name = "dishes")
open class DishEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String = "",
    var description: String = "",
    var price: BigDecimal = BigDecimal.ZERO,
    var isAvailable: Boolean = true
)