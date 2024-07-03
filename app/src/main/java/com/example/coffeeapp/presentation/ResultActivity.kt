package com.example.coffeeapp.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
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
        getOrderForTextView()

    }

    private fun getOrderForTextView(){
        //напиток
        val drink = intent.getStringExtra(KEY_DRINK)
        val drinkString = getString(R.string.for_drink,drink)
        binding.drinkTypes.text = drinkString

        //тип напитка
        val typesOfDrink = intent.getStringExtra(KEY_TYPE_OF_DRINK)
        val typesOfDrinkString = getString(R.string.drinkTypesChoice,typesOfDrink)
        binding.drinkTypesChoice.text = typesOfDrinkString
        //Сахар
        val sugar = intent.getStringExtra(KEY_SUGAR)
        val sugarString = getString(R.string.sugar_count,sugar)
        binding.SugarCount.text = sugarString
        //Сироп
        val sirop = intent.getStringExtra(KEY_SIROP)
            val siropString = getString(R.string.sugar_count,sirop)
            binding.siropCount.text = siropString

        if (drink == KEY_TEA){
            with(binding){
                siropTextView.visibility = View.GONE
                siropCount.visibility = View.GONE
            }
        }
    }



    companion object {

        const val KEY_DRINK = "drink"
        const val KEY_TYPE_OF_DRINK = "types"
        const val KEY_SUGAR = "sugar"
        const val KEY_SIROP = "sirop"
        private const val KEY_TEA = "Чай"

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