package com.example.coffeeapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.coffeeapp.data.AppRepositoryImpl
import com.example.coffeeapp.domain.useCases.GetValidInputUseCase
import com.example.coffeeapp.domain.User

class LogInViewModel:ViewModel() {

    private val repository = AppRepositoryImpl

    private val getValidInputUseCase = GetValidInputUseCase(repository)


    fun validateUser(user:User):Boolean {
        return getValidInputUseCase.getValidInput(user)
    }

}