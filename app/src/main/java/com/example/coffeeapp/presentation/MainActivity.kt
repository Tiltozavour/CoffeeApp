package com.example.coffeeapp.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityMainBinding
import com.example.coffeeapp.domain.User

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val  viewModel by lazy {
        ViewModelProvider(this)[LogInViewModel::class.java]
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

        binding.buttonSignIn.setOnClickListener {
          if (validate())
          { binding.textViewWelcome.text = "GOT IT"
            launchNextPage()
          }
            else { binding.textViewWelcome.text = "Wrong login or password" }
        }


    }

    private fun validate():Boolean{
        val login:String = binding.EditLoginString.text.toString()
        val password:String = binding.EditLoginPassword.text.toString()
        if (login!="" && password != "") {
         return  viewModel.validateUser(User(login,password))
        } else Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
        return false
    }

    private fun launchNextPage(){
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
    }

}