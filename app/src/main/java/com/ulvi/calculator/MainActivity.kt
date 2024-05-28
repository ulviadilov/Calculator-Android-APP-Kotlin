package com.ulvi.calculator

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ulvi.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number1 : Double? = null
    var number2 : Double? = null
    var result : Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


    fun getNumbers() : Boolean{
        number1 = binding.numberOne.text.toString().toDoubleOrNull()
        number2 = binding.numberTwo.text.toString().toDoubleOrNull()
        if(number1 != null && number2 != null){
            return true
        }
        else{
            return false
        }
    }

    fun mySum(view: View){
        if(getNumbers()){
            result = number1!! + number2!!
            binding.resultText.text = "Result: ${result}"
        }
        else
        {
            binding.resultText.text = "Please enter a valid number"
        }
    }

    fun mySub(view: View){
        if (getNumbers()){
            result = number1!! - number2!!
            binding.resultText.text = "Result: ${result}"
        }
        else{
            binding.resultText.text = "Please enter a valid number"
        }
    }

    fun myMultiply(view: View){
        if (getNumbers()){
            result = number1!! * number2!!
            binding.resultText.text = "Result: ${result}"
        }
        else{
            binding.resultText.text = "Please enter a valid number"
        }
    }


    fun myDivide(view: View){
        if (getNumbers() && number2 != 0.0){
            result = number1!! / number2!!
            binding.resultText.text = "Result: ${result}"
        }
        else{
            binding.resultText.text = "Please enter a valid number"
        }
    }



}