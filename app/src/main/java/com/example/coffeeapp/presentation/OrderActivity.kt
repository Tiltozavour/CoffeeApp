package com.example.coffeeapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityOrderBinding
import com.example.coffeeapp.presentation.viewModel.OrderViewModel

class OrderActivity : AppCompatActivity() {

     var DRINK = ""
     var TYPE_OF_DRINK = ""
     var SUGAR = ""
     var SIROP = ""

    private val binding by lazy {
        ActivityOrderBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[OrderViewModel::class.java]
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
        initGreetingsTextView()
        checkedDrinks()
        launchNextPage()
    }

    private fun checkedDrinks(){

        binding.radioGroupDrink.setOnCheckedChangeListener { group, checkedId ->
           when(checkedId) {
               binding.teaRadio.id -> {
                   teaLaunch()
                   DRINK = KEY_TEA
               }
               binding.coffeeRadio.id -> {
                   coffeeLaunch()
                   DRINK = KEY_COFFEE
               }
               binding.cacaoRadio.id -> {
                   cacaoLaunch()
                   DRINK = KEY_CACAO
               }
           }
            binding.textViewTypes.visibility = View.VISIBLE
        }

        }

    private fun teaLaunch() {
        typeOfDrink = getString(R.string.tea)
        typeOfDrinkLabel= getString(R.string.choice_type, typeOfDrink)
        binding.textViewTypes.text = typeOfDrinkLabel
        binding.spinnerChoiceDrink.visibility = View.VISIBLE
        adapterSpinnerForChoiceDrink(resources.getStringArray(R.array.types_of_tea))
        getAddictive(KEY_TEA)
    }

    private fun coffeeLaunch() {
        typeOfDrink = getString(R.string.Coffee)
        typeOfDrinkLabel= getString(R.string.choice_type, typeOfDrink)
        binding.textViewTypes.text = typeOfDrinkLabel
        binding.spinnerChoiceDrink.visibility = View.VISIBLE
        adapterSpinnerForChoiceDrink(resources.getStringArray(R.array.types_of_coffee))
        getAddictive(KEY_COFFEE)
    }

    private fun cacaoLaunch() {
        typeOfDrink = getString(R.string.Cacao)
        typeOfDrinkLabel= getString(R.string.choice_type, typeOfDrink)
        binding.textViewTypes.text = typeOfDrinkLabel
        binding.spinnerChoiceDrink.visibility = View.VISIBLE
        adapterSpinnerForChoiceDrink(resources.getStringArray(R.array.types_of_cacao))
        getAddictive(KEY_CACAO)
    }

    private fun getAddictive(key:String){
        binding.textViewAddictive.visibility = View.VISIBLE


        when(key){
            KEY_TEA -> {
                adapterSpinnerForSugar(resources.getStringArray(R.array.count_of_sugar))
                binding.spinnerAddictiveSugar.visibility = View.VISIBLE
                binding.spinnerAddictiveSirop.visibility = View.GONE
            }
            KEY_COFFEE -> {
                adapterSpinnerForSugar(resources.getStringArray(R.array.count_of_sugar))
                adapterSpinnerForSirop(resources.getStringArray(R.array.choice_of_sirop))
                binding.spinnerAddictiveSugar.visibility = View.VISIBLE
                binding.spinnerAddictiveSirop.visibility = View.VISIBLE
            }
            KEY_CACAO -> {
                adapterSpinnerForSugar(resources.getStringArray(R.array.count_of_sugar))
                adapterSpinnerForSirop(resources.getStringArray(R.array.choice_of_sirop))
                binding.spinnerAddictiveSugar.visibility = View.VISIBLE
                binding.spinnerAddictiveSirop.visibility = View.VISIBLE
            }

        }
    }

    private fun adapterSpinnerForChoiceDrink(type:Array<String>) {
        val adapter:ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, type)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerChoiceDrink.adapter = adapter
    }

    private fun adapterSpinnerForSugar(type:Array<String>) {
        val adapter:ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, type)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerAddictiveSugar.adapter = adapter
    }

    private fun adapterSpinnerForSirop(type:Array<String>) {
        val adapter:ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, type)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerAddictiveSirop.adapter = adapter
    }

    private fun initGreetingsTextView(){
        viewModel.getUserName()
        viewModel.userLogin.observe(this){
            val greetings = getString(R.string.hellow_text,it)
            binding.textViewGreetings.text = greetings
        }
    }


    private fun launchNextPage(){
        binding.buttonNextPage.setOnClickListener {
            TYPE_OF_DRINK =  binding.spinnerChoiceDrink.selectedItem.toString()
            SUGAR = binding.spinnerAddictiveSugar.selectedItem.toString()
            SIROP = binding.spinnerAddictiveSirop.selectedItem.toString()
            val intent = ResultActivity.newIntent(this, DRINK, TYPE_OF_DRINK,SUGAR,SIROP)
            startActivity(intent)
        }

    }

    companion object {

        private var typeOfDrink = "Nothing"
        private var typeOfDrinkLabel = "Nothing"
        private const val KEY_TEA = "Чай"
        private const val KEY_COFFEE = "Кофи"
        private const val KEY_CACAO = "Какаву"

        fun newIntent(context: Context):Intent{
            val intent = Intent(context, OrderActivity::class.java)
            return intent
        }

    }
}