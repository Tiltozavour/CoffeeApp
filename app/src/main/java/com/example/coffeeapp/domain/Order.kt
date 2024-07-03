package com.example.coffeeapp.domain

data class Order(
    val drink:String,
    val typeOfDrink:String,
    val countOfSugar:String,
    val typeOfSirop:String?
)