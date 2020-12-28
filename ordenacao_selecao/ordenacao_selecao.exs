defmodule OrdenacaoSelecao do
  def ordenacao(arr), do: ordenar(arr, [])

  defp ordenar([], acc), do: Enum.reverse(acc)

  defp ordenar(arr, acc) do
    menor_indice = buscar_menor_indice(arr, 0, nil, nil)
    {menor_indice, resto} = List.pop_at(arr, menor_indice)
    ordenar(resto, [menor_indice | acc])
  end

  defguardp novo_menor_valor?(valor, menor_valor) when is_nil(menor_valor) or valor < menor_valor

  defp buscar_menor_indice([], _, _, menor_indice), do: menor_indice

  defp buscar_menor_indice([head | tail], indice, menor_valor, _)
    when novo_menor_valor?(head, menor_valor),
    do: buscar_menor_indice(tail, indice + 1, head, indice)

  defp buscar_menor_indice([_ | tail], indice, menor_valor, menor_indice),
    do: buscar_menor_indice(tail, indice + 1, menor_valor, menor_indice)
end

IO.inspect(OrdenacaoSelecao.ordenacao([5, 3, 6, 2, 10]))
