defmodule DividirConquistar do
  def soma([]), do: 0
  def soma([head | nil]), do: head
  def soma([head | tail]), do: head + soma(tail)

  def conta([]), do: 0
  def conta([_ | nil]), do: 1
  def conta([_ | tail]), do: 1 + conta(tail)

  def maior([]), do: 0
  def maior([head | nil]), do: head
  def maior([head | tail]), do: if head > maior(tail), do: head, else: maior(tail)
end

IO.puts(DividirConquistar.soma([1, 4, 6, 2, 5, 9]))
IO.puts(DividirConquistar.conta([1, 4, 6, 2, 5, 9]))
IO.puts(DividirConquistar.maior([1, 4, 6, 7, 5, 3]))
