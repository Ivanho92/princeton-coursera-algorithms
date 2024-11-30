package mod05_elementary_sorts.sandbox;

import static mod05_elementary_sorts.sandbox.Utils.less;
import static mod05_elementary_sorts.sandbox.Utils.swap;

public class Insertion implements SortAlgorithm {

    public <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            while (j >= 0 && less(array[j+1], array[j])) {
                swap(array, j+1, j);
                j--;
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (less(array[j], array[j-1]))
//                    swap(array, j, j-1);
//                else break;
//            }
//        }
    }
}
