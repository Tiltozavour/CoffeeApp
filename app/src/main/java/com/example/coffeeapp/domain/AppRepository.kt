package com.example.coffeeapp.domain

import androidx.lifecycle.LiveData

interface AppRepository {

    fun getValidInput(user:User):Boolean

    fun getUserNameUseCases():User

}