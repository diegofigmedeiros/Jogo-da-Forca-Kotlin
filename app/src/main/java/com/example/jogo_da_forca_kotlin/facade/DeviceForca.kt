package com.example.jogo_da_forca_kotlin.facade

class DeviceForca {
    private var palavra = String()
    private var dica = String()

    fun jogar() {

        println()
        // Obter uma palavra e respectiva dica;
        print("Escolha uma palavra: ") // Obter a palavra;
        this.palavra = readLine()!!
        print("Escolha uma dica: ")   // Obter a dica;
        this.dica = readLine()!!
        println()

//        val forca = Forca(this.palavra, this.dica)
//
//        // Retornar a quantidade de letras no total;
//        println("Quantidade de Letras da Palavra: ${forca.quantLetras()}")
//        println()
//
//        // Retornar a quantidade de letras distintas;
//        println("Quantidade de Letras Distintas da Palavra:  ${forca.quantLetrasDist()}")
//        println()
//
//        while (!forca.terminou()) {
//            try {
//                println("Letras Usadas: ${forca.letrasUsadas()}")
//                println("Acertos:       ${forca.acertos()}")
//                println("Erros:         ${forca.erros()}")
//                println("Penalidade:    ${forca.penalidade()}")
//                println()
//
//                println("Dica:  ${forca.dica()}")
//                println()
//
//                println(forca.palavraEscondida())
//                println()
//
//                print("Digite uma letra: ")
//                val letra = readLine()!!.uppercase()
//                println()
//
//                // Verificar se é uma unica letra
//                forca.testarLetra(letra)
//
//                // Verificar se uma letra está contida na palavra;
//                forca.descobrirPalavra()
//
//            } catch (e: Throwable) {
//                println(e.message)
//            }
//        }
//        if (forca.resultado()) {
//            println("Você Ganhou!!! :)")
//        } else {
//            println("Você Perdeu... :(")
//        }
//        println("A Palavra era: ${forca.palavra()}")
//
    }
}