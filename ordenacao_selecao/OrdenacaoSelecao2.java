import java.util.Arrays;

public class OrdenacaoSelecao2 {
    public static void main(String[] args) {
       int[] arr = {5, 3, 6, 2, 10};
       System.out.println(Arrays.toString(ordenacaoPorSelecao(arr)));
    }

    public static int[] ordenacaoPorSelecao(int[] arr) {
        int[] novoArr = new int[arr.length];

        for (int i = 0; i < novoArr.length; i++) {
            int menor = buscaMenor(arr);
            novoArr[i] = arr[menor];

            arr = novoArraySemMenor(arr, menor);
        }

        return novoArr;
    }

    private static int[] novoArraySemMenor(int[] arr, int menorIndice) {
        int[] novoArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < menorIndice) novoArr[i] = arr[i];
            else if (i > menorIndice) novoArr[i - 1] = arr[i];
        }

        return novoArr;
    }

    private static int buscaMenor(int[] arr) {
        int menor = arr[0];
        int menorIndice = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < menor) {
                menor = arr[i];
                menorIndice = i;
            }
        }
        return menorIndice;
    }
}
