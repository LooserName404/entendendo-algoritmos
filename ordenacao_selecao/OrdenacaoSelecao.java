import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdenacaoSelecao {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(ordenacaoPorSelecao(arr));
    }

    public static List<Integer> ordenacaoPorSelecao(List<Integer> arr) {
        int length = arr.size();
        List<Integer> novoArr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            var menor = buscaMenor(arr);
            novoArr.add(arr.get(menor));
            arr.remove(menor);
        }
        return novoArr;
    }

    private static int buscaMenor(List<Integer> arr) {
        var menor = arr.get(0);
        var menor_indice = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < menor) {
                menor = arr.get(i);
                menor_indice = i;
            }
        }
        return menor_indice;
    }
}
