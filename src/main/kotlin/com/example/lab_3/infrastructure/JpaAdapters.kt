package com.example.lab_3.infrastructure

import com.example.lab_3.application.DishRepositoryPort
import com.example.lab_3.application.UserRepositoryPort
import com.example.lab_3.domain.Dish
import com.example.lab_3.domain.User
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary // Эта аннотация говорит Spring использовать именно этот адаптер вместо Mock
class UserJpaAdapter(
    private val userJpaRepository: UserJpaRepository
) : UserRepositoryPort {

    override fun findAll(): List<User> =
        userJpaRepository.findAll().map { it.toDomain() }

    override fun findById(id: Long): User? =
        userJpaRepository.findById(id).orElse(null)?.toDomain()

    override fun save(user: User): User {
        val entity = UserEntity(
            id = if (user.id == 0L) null else user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            isActive = user.isActive
        )
        return userJpaRepository.save(entity).toDomain()
    }

    override fun deleteById(id: Long) = userJpaRepository.deleteById(id)

    // Маппер из Entity в Domain
    private fun UserEntity.toDomain() = User(
        id = id ?: 0L,
        email = email,
        firstName = firstName,
        lastName = lastName,
        isActive = isActive
    )
}

@Component
@Primary
class DishJpaAdapter(
    private val dishJpaRepository: DishJpaRepository
) : DishRepositoryPort {

    override fun findAll(): List<Dish> =
        dishJpaRepository.findAll().map { it.toDomain() }

    override fun findById(id: Long): Dish? =
        dishJpaRepository.findById(id).orElse(null)?.toDomain()

    override fun save(dish: Dish): Dish {
        val entity = DishEntity(
            id = if (dish.id == 0L) null else dish.id,
            name = dish.name,
            description = dish.description,
            price = dish.price,
            isAvailable = dish.isAvailable
        )
        return dishJpaRepository.save(entity).toDomain()
    }

    override fun deleteById(id: Long) = dishJpaRepository.deleteById(id)

    override fun findByNamePart(namePart: String): List<Dish> =
        dishJpaRepository.findByNamePart(namePart).map { it.toDomain() }

    // Маппер из Entity в Domain
    private fun DishEntity.toDomain() = Dish(
        id = id ?: 0L,
        name = name,
        description = description,
        price = price,
        isAvailable = isAvailable
    )
}