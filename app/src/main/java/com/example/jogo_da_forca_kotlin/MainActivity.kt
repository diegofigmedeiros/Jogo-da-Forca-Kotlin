package com.example.jogo_da_forca_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import com.example.jogo_da_forca_kotlin.facade.Facade

class MainActivity : AppCompatActivity() {
    private lateinit var facade: Facade
    private lateinit var status: TextView
    private lateinit var letra: EditText
    private lateinit var adivinhar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facade = Facade()

        this.letra = findViewById(R.id.letra)
        this.status = findViewById(R.id.status)
        this.adivinhar = findViewById(R.id.adivinhar)

        this.status.text = facade.status()

        this.adivinhar.setOnClickListener(clickAdivinhar())
    }

    inner class clickAdivinhar: View.OnClickListener {
        override fun onClick(p0: View?) {
            if (this@MainActivity.facade.terminou()) {
                this@MainActivity.adivinhar.isEnabled = false
            }
            val letra = this@MainActivity.letra.text.toString()
            facade.jogar(letra)
            this@MainActivity.status.text = facade.status()
        }
    }
}