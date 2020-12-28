def buscaMenor(array):
    menor = array[0]
    menor_indice = 0
    for i in range(1, len(array)):
        if array[i] < menor:
            menor = array[i]
            menor_indice = i
    return menor_indice


def ordenacaoPorSelecao(array):
    novoArr = []
    for i in range(len(array)):
        menor = buscaMenor(array)
        novoArr.append(array.pop(menor))
    return novoArr


print(ordenacaoPorSelecao([5, 3, 6, 2, 10]))

