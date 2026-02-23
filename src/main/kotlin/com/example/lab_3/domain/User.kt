package com.example.lab_3.domain

data class User(
    val id: Long = 0,
    val email: String,
    val firstName: String,
    val lastName: String,
    val isActive: Boolean
)