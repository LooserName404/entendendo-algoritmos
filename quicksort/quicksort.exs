defmodule Quicksort do
  def quicksort([]), do: []
  def quicksort([head|nil]), do: head
  def quicksort([head | tail]) do
    menores = Enum.filter(tail, fn (x) -> x <= head end)
    maiores = Enum.filter(tail, fn (x) -> x > head end)
    quicksort(menores) ++ [head] ++ quicksort(maiores)
  end
end

IO.inspect(Quicksort.quicksort([10, 5, 2, 3]))
