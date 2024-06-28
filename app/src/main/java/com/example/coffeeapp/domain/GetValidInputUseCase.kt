package com.example.coffeeapp.domain

class GetValidInputUseCase(private val appRepository: AppRepository) {

    fun getValidInput(user:User):Boolean{
        return appRepository.getValidInput(user)
    }
}