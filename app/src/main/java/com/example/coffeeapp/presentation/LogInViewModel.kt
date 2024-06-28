package com.example.coffeeapp.presentation

import androidx.lifecycle.ViewModel
import com.example.coffeeapp.data.AppRepositoryImpl
import com.example.coffeeapp.domain.GetValidInputUseCase
import com.example.coffeeapp.domain.User

class LogInViewModel:ViewModel() {

    private val repository = AppRepositoryImpl

    private val getValidInputUseCase = GetValidInputUseCase(repository)


    fun validateUser(user:User):Boolean {
        return getValidInputUseCase.getValidInput(user)
    }

}