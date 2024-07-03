package com.example.coffeeapp.domain.useCases

import com.example.coffeeapp.domain.AppRepository
import com.example.coffeeapp.domain.User

class GetUserNameUseCases(private val repository: AppRepository) {

    fun getUserNameUseCases(): User {
        return repository.getUserNameUseCases()
    }

}