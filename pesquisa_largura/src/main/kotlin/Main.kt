fun main() {
    val graph = makeGraph()
    breadthFirstSearch(graph)
}

fun breadthFirstSearch(graph: Map<String, List<String>>) {
    val searchQueue = ArrayDeque<String>()
    searchQueue.addAll(graph["voce"]!!.toList())
    val verified = mutableListOf<String>()
    var person = searchQueue.removeFirstOrNull()
    while (person != null) {
        if (person !in verified) {
            if (isSeller(person)) {
                println("$person é um vendedor de manga!")
                return
            } else {
                println("$person não...")
                verified.add(person)
                searchQueue.addAll(graph[person]!!.toList())
            }
        }
        person = searchQueue.removeFirstOrNull()
    }
}

fun isSeller(person: String): Boolean {
    return person[person.length - 1] == 'm'
}

fun makeGraph(): Map<String, List<String>> {
    val graph = HashMap<String, List<String>>()

    graph["voce"] = listOf("alice", "bob", "claire")
    graph["bob"] = listOf("anuj", "peggy")
    graph["alice"] = listOf("peggy")
    graph["claire"] = listOf("thom", "jonny")
    graph["anuj"] = listOf()
    graph["peggy"] = listOf()
    graph["thom"] = listOf()
    graph["jonny"] = listOf()

    return graph
}