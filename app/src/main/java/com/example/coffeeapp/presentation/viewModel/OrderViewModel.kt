package com.example.coffeeapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.data.AppRepositoryImpl
import com.example.coffeeapp.domain.useCases.GetUserNameUseCases

class OrderViewModel:ViewModel() {


    private val repository = AppRepositoryImpl

    private val getUserLogin = GetUserNameUseCases(repository)

    private val _userLogin = MutableLiveData<String>()
    val userLogin:LiveData<String>
        get() = _userLogin


   fun getUserName() {
        _userLogin.value = getUserLogin.getUserNameUseCases().login
    }

}