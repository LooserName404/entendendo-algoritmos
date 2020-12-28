import java.util.Arrays;

public class DividirConquistar {

    public static void main(String[] args) {
        System.out.println(maior(new int[] {5, 1, 5, 3, 67, 13, 2}));
    }

    public static int soma(int[] lista) {
        if (lista.length == 0) return 0;
        return lista[0] + soma(Arrays.copyOfRange(lista, 1, lista.length));
    }

    public static int conta(int[] lista) {
        if (lista.length == 0) return 0;
        return 1 + conta(Arrays.copyOfRange(lista, 1, lista.length));
    }

    public static int maior(int[] lista) {
        if (lista.length == 0) return 0;
        if (lista.length == 1) return lista[0];
        int[] novaLista = Arrays.copyOfRange(lista, 1, lista.length);
        return lista[0] > maior(novaLista) ? lista[0] : maior(novaLista);
    }
}
