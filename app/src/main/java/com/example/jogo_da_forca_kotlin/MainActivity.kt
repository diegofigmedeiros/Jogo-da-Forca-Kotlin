package com.example.jogo_da_forca_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import com.example.jogo_da_forca_kotlin.facade.Facade

class MainActivity : AppCompatActivity() {
    private lateinit var facade: Facade
    private lateinit var status: TextView
    private lateinit var letra: EditText
    private lateinit var adivinhar: Button
    private lateinit var imagem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facade = Facade()

        this.letra     = findViewById(R.id.letra)
        this.status    = findViewById(R.id.status)
        this.status.text = facade.status()
        this.adivinhar = findViewById(R.id.adivinhar)
        this.imagem    = findViewById(R.id.imagem)

        this.adivinhar.setOnClickListener{
            val letra = this.letra.text.toString()
            this.facade.jogar(letra)
            this.letra.setText("")
            this.status.text = facade.status()
            var imagemforca = "forca${facade.errosImagem()}"
            this.imagem.setImageResource(resources.getIdentifier(imagemforca, "drawable", packageName))

            }
        }
    }
}
