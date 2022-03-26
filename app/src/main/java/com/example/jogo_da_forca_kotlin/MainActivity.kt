package com.example.jogo_da_forca_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.jogo_da_forca_kotlin.facade.Facade

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Facade
    private lateinit var view: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jogo = Facade()
        view = findViewById(R.id.tv_status)
        view.text = jogo.status()
    }

    fun {}
}