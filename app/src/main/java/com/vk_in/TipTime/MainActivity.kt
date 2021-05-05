package com.vk_in.TipTime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //id set
        val offlite = findViewById<ImageView>(R.id.offlite)
        val onlite = findViewById<ImageView>(R.id.onlite)
        val toggle: ToggleButton = findViewById(R.id.toggleButton)
        //setOnclicklener

        toggle.setOnCheckedChangeListener { _:CompoundButton?, isChecked ->
           if (isChecked){
               onlite.setBackgroundColor(0xff00ff00.toInt())
           }
            else{
                offlite.setBackgroundColor(0xffff0000.toInt())
           }



        }

    }
}

private fun ImageView.setBackground(on: Int) {

    val isChecked = false
    if (isChecked) {
        val offlite = null
        offlite?.setBackground(R.drawable.off)
    }

    else {
        val onlite = null
        onlite?.setBackground(R.drawable.on)
    }
}
