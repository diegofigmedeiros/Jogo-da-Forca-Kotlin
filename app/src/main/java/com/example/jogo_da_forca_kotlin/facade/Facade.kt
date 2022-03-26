package com.example.jogo_da_forca_kotlin.facade

import com.example.jogo_da_forca_kotlin.model.Forca
import com.example.jogo_da_forca_kotlin.repository.BancoPalavras

class Facade {
    private var banco: BancoPalavras = BancoPalavras()
    private var forca: Forca

    init {
        this.banco.sortear()
        this.forca = Forca(this.banco.palavra(), this.banco.dica())
    }

    fun banco(): BancoPalavras {
        return this.banco
    }

    fun jogar() {

        while (!this.forca.terminou()) {
            try {
                status()

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
        when (this.forca.resultado()) {
            true -> println("Você Ganhou!!! :)")
            else -> println("Você Perdeu... :(")
        }

        println("A Palavra era: ${this.forca.palavra()}")
        println()

        println("Deseja jogar mais uma vez? [S/N]")
        var reiniciar = readLine()!!
        reiniciar.uppercase()
//        when (reiniciar) {
//            "S" ->
//            "N" -> exitProcess(1)
//        }
    }

    fun status(): String {
        var output = String()
        // Retornar a Dica da Palavra;
        output += "Dica:                     ${this.forca.dica()}"
        output += "\n"

        output += "\n"
        output += "Quant. Letras:            ${this.forca.quantLetras()}"
        output += "\n"

        // Retornar a quantidade de letras distintas;
        output += "Quant. Letras Distintas:  ${this.forca.quantLetrasDist()}"
        output += "\n"
        // Retornar Letras Usadas;
        output += "Letras Usadas: ${this.forca.letrasUsadas()}"
        output += "\n"
        // Retornar Acertos;
        output += "Acertos:       ${this.forca.acertos()}"
        output += "\n"
        output += "Erros:         ${this.forca.erros()}"
        output += "\n"
        output += "Penalidade:    ${this.forca.penalidade()}"
        output += "\n"

        output += "\n"
        output += this.forca.palavraEscondida()
        output += "\n"

        return output
    }
}
