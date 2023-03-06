package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.coroutine.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {

            runBlocking {
                value()
            }
        }
    }
    suspend fun value(){
        delay(2000)
        var currentNumber = 0
        val number = binding.editable.text.toString().toInt()
        val result = number + 1 + currentNumber
        currentNumber = number
        currentNumber++
        binding.number.text = result.toString()
    }
}
