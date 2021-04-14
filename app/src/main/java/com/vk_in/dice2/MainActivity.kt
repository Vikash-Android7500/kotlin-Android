package com.vk_in.dice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vk_in.dice2.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.caunter.setOnClickListener { calculateTip() }

    }

    private fun calculateTip() {
        val stringInTextField = binding.amaunt.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.result.text = ""
            Toast.makeText(this, "Result",  Toast.LENGTH_SHORT).show()
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.r1 -> 0.15
            R.id.r2 -> 0.18
            else -> 0.20
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.result.text = getString(R.string.tip_amount, formattedTip)
    }
}


