package com.example.coffeeapp.data

import com.example.coffeeapp.domain.AppRepository
import com.example.coffeeapp.domain.User

object AppRepositoryImpl:AppRepository {

    override fun getValidInput(user: User): Boolean {
        return user.login == User().login && user.password == User().password
    }

    override fun getUserNameUseCases(): User {
        return User()
    }
}