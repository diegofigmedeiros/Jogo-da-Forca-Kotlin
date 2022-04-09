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

    fun terminou(): Boolean {
        return this.forca.terminou()
    }

    fun jogar(letra: String) {
        try {
            // Verificar se uma letra está contida na palavra;
            this.forca.descobrirPalavra(letra.uppercase())

        } catch (e: Throwable) {
            println(e.message)
        }

    }

    fun errosImagem(): Int {
        return this.forca.erros() + 1
    }

    fun resultado(): Boolean {
        return this.forca.resultado()
    }

    fun status(): String {
        var output = String()
        // Retornar a Dica da Palavra;
        output += "Dica: ${this.forca.dica()}"
        output += "\n"
        output += "Quant. Letras: ${this.forca.quantLetras()}"
        output += "\n"
        // Retornar a quantidade de letras distintas;
        output += "Quant. Letras Dist.: ${this.forca.quantLetrasDist()}"
        output += "\n"
        // Retornar Letras Usadas;
        output += "Letras Usadas: ${this.forca.letrasUsadas()}"
        output += "\n"
        // Retornar Acertos;
        output += "Acertos: ${this.forca.acertos()}"
        output += "\n"
        output += "Erros:   ${this.forca.erros()}"
        //output += "\n"
        //output += "Penalidade:    ${this.forca.penalidade()}"
        //output += "\n"
        output += "\n"
        output += "\n"
        output += this.forca.palavraEscondida()
        return output
    }
}
