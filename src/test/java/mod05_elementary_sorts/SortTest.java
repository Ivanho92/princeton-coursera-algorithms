package mod05_elementary_sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {

    Sort sort = new SelectionSort<Integer>();

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    } 

    private boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i-1]))
                return false;
        }
        return true;
    }

    @Test
    void testSortingEmptyArray() {
        Comparable[] input = {};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).isEmpty();
    }

    @Test
    void testSortingSingleElement() {
        Comparable[] input = {42};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(42);
    }

    @Test
    void testSortingAlreadySorted() {
        Comparable[] input = {1, 2, 3, 4, 5};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void testSortingReverseOrder() {
        Comparable[] input = {5, 4, 3, 2, 1};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void testSortingUnsortedArray() {
        Comparable[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
    }

    @Test
    void testSortingWithDuplicates() {
        Comparable[] input = {3, 3, 3, 3};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(3, 3, 3, 3);
    }

    @Test
    void testSortingNegativeNumbers() {
        Comparable[] input = {-5, -1, -10, 0, 5};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(-10, -5, -1, 0, 5);
    }

    @Test
    void testSortingMixedNumbers() {
        Comparable[] input = {-1, 2, -3, 4, 0};
        sort.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(-3, -1, 0, 2, 4);
    }

    @Test
    void testSortingPerformance() {
        Comparable[] input = new Comparable[10_000];
        for (int i = 0; i < 10_000; i++) {
            input[i] = 10_000 - i;  // Fill array in reverse order
        }
        long start = System.nanoTime();
        sort.sort(input);
        long duration = System.nanoTime() - start;
        assertThat(isSorted(input)).isTrue();
        assertThat(duration).isLessThan(1_000_000_000);  // Ensure it runs under 1 second
    }
}