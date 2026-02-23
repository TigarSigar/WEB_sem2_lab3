package com.example.lab_3.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : JpaRepository<UserEntity, Long> {
    // Подход A: Производный метод (Derived Method)
    // Spring сам поймет, что нужно искать по email
    fun findByEmail(email: String): UserEntity?
}

@Repository
interface DishJpaRepository : JpaRepository<DishEntity, Long> {
    // Подход B: JPQL запрос (@Query)
    // Согласно spec.yaml, нам нужен поиск по части имени
    @Query("SELECT d FROM DishEntity d WHERE d.name LIKE %:namePart%")
    fun findByNamePart(namePart: String): List<DishEntity>
}