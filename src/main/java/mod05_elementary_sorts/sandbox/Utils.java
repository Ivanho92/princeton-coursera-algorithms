package mod05_elementary_sorts.sandbox;

public class Utils {

    private Utils() {}

    public static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int a, int b) {
        var tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length - 1; i++)
            if (less(array[i], array[i - 1])) return false;
        return true;
    }
}
