defmodule PesquisaBinaria do
  def pesquisa_binaria(lista, item) do
    baixo = 0
    alto = length(lista) - 1

    pesquisar(lista, item, baixo, alto)
  end

  defp pesquisar(_, _, baixo, alto) when alto < baixo, do: nil

  defp pesquisar(lista, item, baixo, alto) do
    meio = div(baixo + alto, 2)
    chute = Enum.at(lista, meio)

    cond do
      chute == item -> meio
      chute > item -> pesquisar(lista, item, baixo, meio - 1)
      true -> pesquisar(lista, item, meio + 1, alto)
    end
  end
end

minha_lista = [1, 3, 5, 7, 9]
IO.puts(PesquisaBinaria.pesquisa_binaria(minha_lista, 3))
IO.inspect(PesquisaBinaria.pesquisa_binaria(minha_lista, -1))
