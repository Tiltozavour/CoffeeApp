package com.example.coffeeapp.domain

interface AppRepository {
    fun getValidInput(user:User):Boolean
}