package mod05_elementary_sorts.sandbox;

import static mod05_elementary_sorts.sandbox.Utils.less;
import static mod05_elementary_sorts.sandbox.Utils.swap;

public class Shell implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n / 3)
            h = 3*h + 1;

        while (h > 0) {
            for (int i = h; i < n; i++) {
                int j = i;
                while (j >= h && less(array[j], array[j-h])) {
                    swap(array, j, j-h);
                    j -= h;
                }
            }

            h /= 3;
        }
    }
}
