package com.example.coffeeapp.domain.useCases

import com.example.coffeeapp.domain.AppRepository
import com.example.coffeeapp.domain.User

class GetValidInputUseCase(private val appRepository: AppRepository) {

    fun getValidInput(user: User):Boolean{
        return appRepository.getValidInput(user)
    }
}