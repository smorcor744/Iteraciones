fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersRev = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else {
        println("Correcto")
    }
    println(numbersRev)

    // Prueba con lista de valores numéricos Int, Float y Double
    val numeros = listOf(1, 2.2f, 3.333)
    val numerosRev = reverse(numeros)
    if (!listOf(3.333, 2.2f, 1).equals(numerosRev))
        println("Error")
    else
        println("Correcto")
    println(numerosRev)

    // Prueba con lista de cualquier data class inventada
    val inventada = Inventada(listOf("mercedes", "audi", "citroen", "opel", 3))

    val abcnumerosRev = reverse(inventada.coches)
    if (!listOf(3, "opel", "citroen", "audi", "mercedes").equals(abcnumerosRev))
        println("Error")
    else
        println("Correcto")
    println(inventada.coches)

    // Prueba con lista de tipos de datos distintos
    val mixedData = listOf("String", 42, 3.14, inventada)
    val mixedDataRev = reverse(mixedData)
    if (!listOf(inventada, 3.14, 42, "String").equals(mixedDataRev))
        println("Error")
    else
        println("Correcto")
    println(mixedDataRev)
}
//fun <T> reverse(elementos: List<T>): List<T> {
//    val newlista = mutableListOf<T>()
//    val pila = Pila<T>()
//
//    for (elemento in elementos) {
//        pila.push(elemento)
//    }
//
//    while (!pila.isEmpty()) newlista.add(pila.pop()!!)
//
//    return newlista
//}

fun <T> reverse(elementos: List<T>): List<T> {
    val newlista = mutableListOf<T>()
    val pila = Pila<T>()

    val iterator = elementos.iterator()
    while (iterator.hasNext()) {
        pila.push(iterator.next())
    }

    while (!pila.isEmpty()) {
        newlista.add(pila.pop()!!)
    }

    return newlista
}

data class Inventada(val coches: List<Any>){
}
class Pila<T> {
    private val elementos = mutableListOf<T>()

    fun top(): T? {
        return elementos.lastOrNull()
    }
    fun push(elemento: T) {
         elementos.add(elemento)
    }
    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return elementos.removeLast()

    }

    fun isEmpty(): Boolean{
        return elementos.isEmpty()
    }


}