package com.example.jogo_da_forca_kotlin.repository

class BancoPalavras {
    private var listaPalavras = HashMap<String, String>()
    private var palavra = String()

    init {
        listaPalavras.putAll(mapOf("Bola" to "Redonda", "Chocolate" to "Cacau", "Morango" to "Rosa"))
    }

    fun add(palavra: String, dica: String) {
        this.listaPalavras[palavra] = dica
    }

    fun remove(palavra: String) {
        this.listaPalavras.remove(palavra)
    }

    fun sortear() {
        this.palavra = this.listaPalavras.keys.random()
    }

    fun palavra(): String {
        return this.palavra
    }

    fun dica(): String {
        return this.listaPalavras.getValue(this.palavra)
    }
}