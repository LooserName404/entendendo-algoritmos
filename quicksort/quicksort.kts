import kotlin.random.Random

fun quicksort(list: List<Int>): List<Int> {
    if (list.size <= 1) return list

    val pivo = list[Random.nextInt(0, list.size)]
    val menores = list.filter { it < pivo }
    val maiores = list.filter { it > pivo }

    return quicksort(menores) + listOf(pivo) + quicksort(maiores)
}

println(quicksort(listOf(10, 5, 2, 3)))
