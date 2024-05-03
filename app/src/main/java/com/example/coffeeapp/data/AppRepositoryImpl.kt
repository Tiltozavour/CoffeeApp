package com.example.coffeeapp.data

import com.example.coffeeapp.domain.AppRepository
import com.example.coffeeapp.domain.User

object AppRepositoryImpl:AppRepository {

    override fun getValidInput(user: User): Boolean {
        return user.login == "admin" && user.password == "1531"
    }
}