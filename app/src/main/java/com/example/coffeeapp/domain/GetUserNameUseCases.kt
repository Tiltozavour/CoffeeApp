package com.example.coffeeapp.domain

class GetUserNameUseCases(private val repository: AppRepository) {

    fun getUserNameUseCases():User{
        return repository.getUserNameUseCases()
    }

}