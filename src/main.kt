import model.JogoDaForca

fun main() {
    // Obter uma palavra e respectiva dica;
    print("Escolha uma palavra: ") // Obter a palavra;
    val palavra = readLine()!!
    print("Escolha uma dica: ")   // Obter a dica;
    val dica = readLine()!!
    println()

    val jogoDaForca = JogoDaForca(palavra, dica)

    // Retornar a quantidade de letras no total;
    println("Quantidade de Letras da Palavra: ${jogoDaForca.quantLetras()}")
    println()

    // Retornar a quantidade de letras distintas;
    println("Quantidade de Letras Distintas da Palavra:  ${jogoDaForca.quantLetrasDist()}")
    println()

    while (!jogoDaForca.terminou()) {
        try {
            println("Letras Usadas: ${jogoDaForca.letrasUsadas()}")
            println("Acertos:       ${jogoDaForca.acertos()}")
            println("Erros:         ${jogoDaForca.erros()}")
            println("Penalidade:    ${jogoDaForca.penalidade()}")
            println()

            println("Dica:  ${jogoDaForca.dica()}")
            println()

            println(jogoDaForca.palavraEscondida())
            println()

            print("Digite uma letra: ")
            val letra = readLine()!!.uppercase()
            println()

            // Verificar se é uma unica letra
            jogoDaForca.testarLetra(letra)

            // Verificar se uma letra está contida na palavra;
            jogoDaForca.descobrirPalavra()

        } catch (e: Throwable) {
            println(e.message)
        }
    }
    if (jogoDaForca.resultado()) {
        println("Você Ganhou!!! :)")
    } else {
        println("Você Perdeu... :(")
    }
    println("A Palavra era: ${jogoDaForca.palavra()}")

}