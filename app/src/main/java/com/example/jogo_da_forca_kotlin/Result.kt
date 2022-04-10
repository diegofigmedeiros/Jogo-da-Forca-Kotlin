package com.example.jogo_da_forca_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Result : AppCompatActivity() {
    private lateinit var imageresult: ImageView
    private lateinit var textresult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.imageresult = findViewById(R.id.imageresult)
        this.textresult = findViewById(R.id.textresult)

        if (intent.hasExtra("Result")) {
            if (intent.getStringExtra("Result") == "Ganhou") {
                this.imageresult.setImageResource(resources.getIdentifier("ganhou", "drawable", packageName))
                this.textresult.text = intent.getStringExtra("Result")
            }
            else {
                this.imageresult.setImageResource(resources.getIdentifier("perdeu", "drawable", packageName))
                this.textresult.text = intent.getStringExtra("Result")
            }
        }
    }

}