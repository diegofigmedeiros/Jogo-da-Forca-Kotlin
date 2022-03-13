import com.example.jogo_da_forca_kotlin.facade.ConsoleForca

fun main() {
    // Escolher entre Console ou Device
    println("Console [1]: ")
    println("Device  [2]: ")
    print("Escolha: ")
    val view = readLine()

    // Note the block
    when (view) {
        "1" -> {
            ConsoleForca()
        }

        "2" -> {
            print("view: 2")
        }

        else -> {
            print("Selecione 1 ou 2")
        }
    }



}