import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quicksort(new int[] {10, 5, 2, 3})));
    }

    public static int[] quicksort(int[] array) {
        if (array.length < 2) return array;

        int pivo = array[0];
        int[] menores = Arrays.stream(array).skip(1).filter(it -> it <= pivo).toArray();
        int[] maiores = Arrays.stream(array).skip(1).filter(it -> it > pivo).toArray();

        return concat(quicksort(menores), new int[] {pivo}, quicksort(maiores));
    }

    public static int[] concat(int[]... arrays) {
        int size = 0;
        for (int[] array: arrays) {
            size += array.length;
        }

        var concatenated = new int[size];
        var current = 0;
        for (int[] array: arrays) {
            for (int item: array) {
                concatenated[current++] = item;
            }
        }
        return concatenated;
    }
}
