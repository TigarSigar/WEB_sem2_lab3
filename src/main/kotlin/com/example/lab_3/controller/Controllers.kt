package com.example.lab_3.controller

import com.example.lab_3.application.DishService
import com.example.lab_3.application.UserService
import com.example.lab_3.domain.Dish
import com.example.lab_3.domain.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll() = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getUserById(id)

    @PostMapping
    fun create(@RequestBody user: User) = userService.createUser(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = userService.deleteUser(id)
}

@RestController
@RequestMapping("/api/v1/dishes")
class DishController(private val dishService: DishService) {

    @GetMapping
    fun getAll(@RequestParam(required = false) namePart: String?) =
        dishService.getAllDishes(namePart)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = dishService.getDishById(id)

    @PostMapping
    fun create(@RequestBody dish: Dish) = dishService.createDish(dish)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = dishService.deleteDish(id)
}