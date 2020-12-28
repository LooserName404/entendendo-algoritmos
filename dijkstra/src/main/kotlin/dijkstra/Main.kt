package dijkstra

fun main() {
    val graph = makeGraph()
    val costs = makeCosts()
    val parents = makeParents()

    var node = lowestCost(costs)

    println(graph)
    println(costs)
    println(parents)
    println()

    val processed = mutableListOf<String>()

    while (node.isNotEmpty()) {
        var cost = costs[node]
        var neighbors = graph[node]
        for (n in neighbors!!.keys) {
            var newCost = cost!! + neighbors[n]!!
            if (costs[n]!! > newCost) {
                (costs as MutableMap)[n] = newCost
                (parents as MutableMap)[n] = node
            }
        }
        println(costs)
        println(parents)
        println()
        processed.add(node)
        node = lowestCost(costs, processed)
    }
}

fun lowestCost(costs: Map<String, Int>, processed: List<String> = listOf()): String {
    var lowest = Int.MAX_VALUE
    var lowestKey = ""
    for ((key, value) in costs) {
        if (value < lowest && key !in processed ) {
            lowest = value
            lowestKey = key
        }
    }

    return lowestKey
}

fun makeGraph(): Map<String, Map<String, Int>> {
    val graph = mutableMapOf<String, Map<String, Int>>()

    graph["inicio"] = mutableMapOf()
    val inicio = graph["inicio"] as MutableMap
    inicio["a"] = 6
    inicio["b"] = 2

    graph["a"] = mutableMapOf()
    val a = graph["a"] as MutableMap
    a["fim"] = 1

    graph["b"] = mutableMapOf()
    val b = graph["b"] as MutableMap
    b["a"] = 3
    b["fim"] = 5

    graph["fim"] = mutableMapOf()

    return graph
}

fun makeCosts(): Map<String, Int> {
    val costs = mutableMapOf<String, Int>()

    costs["a"] = 6
    costs["b"] = 2
    costs["fim"] = Double.POSITIVE_INFINITY.toInt()

    return costs
}

fun makeParents(): Map<String, String> {
    val parents = mutableMapOf<String, String>()

    parents["a"] = "inicio"
    parents["b"] = "inicio"
    parents["fim"] = ""

    return parents
}