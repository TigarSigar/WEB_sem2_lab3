package com.example.lab_3.application

import com.example.lab_3.domain.Dish
import com.example.lab_3.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepositoryPort: UserRepositoryPort
) {
    fun getAllUsers(): List<User> = userRepositoryPort.findAll()

    fun getUserById(id: Long): User? = userRepositoryPort.findById(id)

    fun createUser(user: User): User = userRepositoryPort.save(user)

    fun deleteUser(id: Long) = userRepositoryPort.deleteById(id)
}

@Service
class DishService(
    private val dishRepositoryPort: DishRepositoryPort
) {
    fun getAllDishes(namePart: String? = null): List<Dish> {
        return if (namePart != null) {
            dishRepositoryPort.findByNamePart(namePart)
        } else {
            dishRepositoryPort.findAll()
        }
    }

    fun getDishById(id: Long): Dish? = dishRepositoryPort.findById(id)

    fun createDish(dish: Dish): Dish = dishRepositoryPort.save(dish)

    fun deleteDish(id: Long) = dishRepositoryPort.deleteById(id)
}