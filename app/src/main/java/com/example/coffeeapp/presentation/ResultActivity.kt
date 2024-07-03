package com.example.coffeeapp.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //напиток
        val drink = intent.getStringExtra(KEY_DRINK)
        val greetings = getString(R.string.for_drink,drink)
        binding.drinkTypes.text = greetings

            //тип напитка
        val typesOfDrink = intent.getStringExtra(KEY_TYPE_OF_DRINK)
        val greetings2 = getString(R.string.drinkTypesChoice,typesOfDrink)
        binding.drinkTypesChoice.text = greetings2

            //Сахар
        val sugar = intent.getStringExtra(KEY_SUGAR)
        val greetings3 = getString(R.string.sugar_count,sugar)
        binding.SugarCount.text = greetings3

            //Сироп
        val sirop = intent.getStringExtra(KEY_SIROP)
        val greetings4 = getString(R.string.sugar_count,sirop)
        binding.siropCount.text = greetings4



    }

    companion object {

        const val KEY_DRINK = "drink"
        const val KEY_TYPE_OF_DRINK = "types"
        const val KEY_SUGAR = "sugar"
        const val KEY_SIROP = "sirop"

        fun newIntent(context: Context,drink:String,typeDrink:String,sugar:String,sirop:String):Intent{
            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra(KEY_DRINK,drink)
            intent.putExtra(KEY_TYPE_OF_DRINK,typeDrink)
            intent.putExtra(KEY_SUGAR,sugar)
            intent.putExtra(KEY_SIROP,sirop)
            return intent
        }

    }


}