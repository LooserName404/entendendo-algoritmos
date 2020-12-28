/**
 * PesquisaBinaria
 */
public class PesquisaBinaria {

    public static void main(String[] args) {
        int[] minhaLista = {1, 3, 5, 7, 9};
        System.out.println(pesquisaBinaria(minhaLista, 3));
        System.out.println(pesquisaBinaria(minhaLista, -1));
        System.out.println(pesquisaBinaria(minhaLista, 5));
    }

    public static int pesquisaBinaria(int[] lista, int item) {
        var baixo = 0;
        var alto = lista.length - 1;

        while (baixo <= alto) {
            var meio = (baixo + alto) / 2;
            var chute = lista[meio];
            if (chute == item) return meio;
            if (chute > item) alto = meio - 1;
            else baixo = meio + 1;
        }
        return -1;
    }
}
