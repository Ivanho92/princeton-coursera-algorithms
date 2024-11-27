package mod05_elementary_sorts.sandbox;

import static mod05_elementary_sorts.sandbox.Utils.less;
import static mod05_elementary_sorts.sandbox.Utils.swap;

public class Selection {

    private Selection() {}

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if(less(array[j], array[min]))
                    min = j;
            swap(array, min, i);
        }
    }
}
