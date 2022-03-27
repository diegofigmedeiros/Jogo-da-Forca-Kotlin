package com.example.jogo_da_forca_kotlin.facade

import com.example.jogo_da_forca_kotlin.model.Forca
import com.example.jogo_da_forca_kotlin.repository.BancoPalavras
import kotlin.system.exitProcess

class ConsoleForca {
    private var banco: BancoPalavras = BancoPalavras()
    private var palavra: String
    private var dica: String
    private var forca: Forca

    init {
        this.banco.sortear()
        this.palavra = banco.palavra()
        this.dica = banco.dica()
        this.forca = Forca(this.palavra, this.dica)
    }

    fun jogar() {
//        println()
//        // Obter uma palavra e respectiva dica;
//        print("Escolha uma palavra: ") // Obter a palavra;
//        this.palavra = readLine()!!
//        print("Escolha uma dica: ")   // Obter a dica;
//        this.dica = readLine()!!
//        println()

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

                // Verificar se uma letra está contida na palavra;
                this.forca.descobrirPalavra(letra)

            } catch (e: Throwable) {
                println(e.message)
            }
        }
        when (this.forca.resultado()) {
            true -> println("Você Ganhou!!! :)")
            else -> println("Você Perdeu... :(")
        }

        println("A Palavra era: ${this.forca.palavra()}")
        println()

        println("Deseja jogar mais uma vez? [S/N]")
        var reiniciar = readLine()!!
        reiniciar.uppercase()
        when (reiniciar) {
            "N" -> exitProcess(1)
        }
    }
}