package com.example.lab_3.infrastructure

import com.example.lab_3.application.DishRepositoryPort
import com.example.lab_3.application.UserRepositoryPort
import com.example.lab_3.domain.Dish
import com.example.lab_3.domain.User
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class UserMockRepository : UserRepositoryPort {
    private val storage = mutableMapOf<Long, User>()
    private var idGenerator = AtomicLong(1)

    override fun findAll(): List<User> = storage.values.toList()

    override fun findById(id: Long): User? = storage[id]

    override fun save(user: User): User {
        val id = if (user.id == 0L) idGenerator.getAndIncrement() else user.id
        val savedUser = user.copy(id = id)
        storage[id] = savedUser
        return savedUser
    }

    override fun deleteById(id: Long) {
        storage.remove(id)
    }
}

@Component
class DishMockRepository : DishRepositoryPort {
    private val storage = mutableMapOf<Long, Dish>()
    private var idGenerator = AtomicLong(1)

    override fun findAll(): List<Dish> = storage.values.toList()

    override fun findById(id: Long): Dish? = storage[id]

    override fun save(dish: Dish): Dish {
        val id = if (dish.id == 0L) idGenerator.getAndIncrement() else dish.id
        val savedDish = dish.copy(id = id)
        storage[id] = savedDish
        return savedDish
    }

    override fun deleteById(id: Long) {
        storage.remove(id)
    }

    override fun findByNamePart(namePart: String): List<Dish> {
        return storage.values.filter { it.name.contains(namePart, ignoreCase = true) }
    }
}