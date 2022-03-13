package com.example.jogo_da_forca_kotlin.facade

import com.example.jogo_da_forca_kotlin.model.Forca
import com.example.jogo_da_forca_kotlin.repository.BancoPalavras

class ConsoleForca {
    private var banco: BancoPalavras = BancoPalavras()
    private var palavra: String
    private var dica: String
    private lateinit var forca: Forca

    init {
        this.banco.sortear()
        this.palavra = banco.palavra()
        this.dica = banco.dica()
    }

    private fun addForca(palavra: String, dica: String) {
        this.forca = Forca(palavra, dica)
    }

    fun jogar() {
//        println()
//        // Obter uma palavra e respectiva dica;
//        print("Escolha uma palavra: ") // Obter a palavra;
//        this.palavra = readLine()!!
//        print("Escolha uma dica: ")   // Obter a dica;
//        this.dica = readLine()!!
//        println()

        addForca(this.palavra, this.dica)

        // Retornar a quantidade de letras no total;
        println("Quantidade de Letras da Palavra: ${this.forca.quantLetras()}")
        println()

        // Retornar a quantidade de letras distintas;
        println("Quantidade de Letras Distintas da Palavra:  ${this.forca.quantLetrasDist()}")
        println()

        while (!this.forca.terminou()) {
            try {
                println("Letras Usadas: ${this.forca.letrasUsadas()}")
                println("Acertos:       ${this.forca.acertos()}")
                println("Erros:         ${this.forca.erros()}")
                println("Penalidade:    ${this.forca.penalidade()}")
                println()

                println("Dica:  ${this.forca.dica()}")
                println()

                println(this.forca.palavraEscondida())
                println()

                print("Digite uma letra: ")
                val letra = readLine()!!.uppercase()
                println()

                // Verificar se é uma unica letra
                this.forca.testarLetra(letra)

                // Verificar se uma letra está contida na palavra;
                this.forca.descobrirPalavra()

            } catch (e: Throwable) {
                println(e.message)
            }
        }
        if (this.forca.resultado()) {
            println("Você Ganhou!!! :)")
        } else {
            println("Você Perdeu... :(")
        }
        println("A Palavra era: ${this.forca.palavra()}")

    }
}