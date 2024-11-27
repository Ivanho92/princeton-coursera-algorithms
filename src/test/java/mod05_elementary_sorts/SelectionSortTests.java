package mod05_elementary_sorts;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import mod05_elementary_sorts.sandbox.Selection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static mod05_elementary_sorts.sandbox.Utils.isSorted;
import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortTests {

    @Test
    void testSortingEmptyArray() {
        Integer[] input = {};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).isEmpty();
    }

    @Test
    void testSortingSingleElement() {
        Integer[] input = {42};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(42);
    }

    @Test
    void testSortingAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void testSortingReverseOrder() {
        Integer[] input = {5, 4, 3, 2, 1};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void testSortingUnsortedArray() {
        Integer[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
    }

    @Test
    void testSortingWithDuplicates() {
        Integer[] input = {3, 3, 3, 3};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(3, 3, 3, 3);
    }

    @Test
    void testSortingNegativeNumbers() {
        Integer[] input = {-5, -1, -10, 0, 5};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(-10, -5, -1, 0, 5);
    }

    @Test
    void testSortingMixedNumbers() {
        Integer[] input = {-1, 2, -3, 4, 0};
        Selection.sort(input);
        assertThat(isSorted(input)).isTrue();
        assertThat(input).containsExactly(-3, -1, 0, 2, 4);
    }

    @Test
    void testSortingPerformance_10_000() {
        // Fill array in reverse order
        int capacity = 10_000;
        Integer[] input = new Integer[capacity];
        for (int i = 0; i < capacity; i++)
            input[i] = capacity - i;

        // Ensure it runs under 1 second
        Stopwatch watch = new Stopwatch();
        Selection.sort(input);
        StdOut.println(watch.elapsedTime());
        assertThat(watch.elapsedTime()).isLessThan(1);
        assertThat(isSorted(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {
        1_250, 2_500, 5_000, 10_000, 20_000,
        40_000, 80_000, 160_000, 320_000
    })
    void testSortingPerformance_100_000(int number) {
        testSortingPerformance(number);
    }

    private void testSortingPerformance(int capacity) {
        // Given array in reverse order
        Integer[] input = new Integer[capacity];
        for (int i = 0; i < capacity; i++)
            input[i] = capacity - i;

        // Print out performance
        Stopwatch watch = new Stopwatch();
        Selection.sort(input);
        StdOut.println("Performance test with N=" + capacity);
        StdOut.println(watch.elapsedTime() + " sec.\n");

        // Make sure it's sorted
        assertThat(isSorted(input)).isTrue();
    }
}