package com.example.coffeeapp.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityMainBinding
import com.example.coffeeapp.domain.User
import com.example.coffeeapp.presentation.viewModel.LogInViewModel

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
          { binding.textViewWelcome.text = resources.getText(R.string.success)
            launchNextPage()
          }
            else { binding.textViewWelcome.text = resources.getText(R.string.warning_wrong_info) }
        }


    }

    private fun validate():Boolean{
        val login:String = binding.EditLoginString.text.toString().trim()
        val password:String = binding.EditLoginPassword.text.toString().trim()
        if (login.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, R.string.warning_empty_toast, Toast.LENGTH_SHORT).show()
            return false
        } else  return  viewModel.validateUser(User(login,password))
    }

    private fun launchNextPage() {
        val intent = OrderActivity.newIntent(this)
        startActivity(intent)
    }

}