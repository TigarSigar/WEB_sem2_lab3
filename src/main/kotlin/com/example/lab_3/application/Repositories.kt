package com.example.lab_3.application

import com.example.lab_3.domain.Dish
import com.example.lab_3.domain.User

interface UserRepositoryPort {
    fun findAll(): List<User>
    fun findById(id: Long): User?
    fun save(user: User): User
    fun deleteById(id: Long)
}

interface DishRepositoryPort {
    fun findAll(): List<Dish>
    fun findById(id: Long): Dish?
    fun save(dish: Dish): Dish
    fun deleteById(id: Long)
    // Добавим метод для фильтрации по имени, который пригодится позже для JPQL
    fun findByNamePart(namePart: String): List<Dish>
}