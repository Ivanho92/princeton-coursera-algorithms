package mod05_elementary_sorts.sandbox;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static mod05_elementary_sorts.sandbox.Utils.isSorted;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseSortTests {

    // Abstract method to provide the sorting algorithm
    protected abstract SortAlgorithm getSortAlgorithm();

    @Test
    void testSortingEmptyArray() {
        Integer[] input = {};
        getSortAlgorithm().sort(input);
        assertThat(input).isEmpty();
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingSingleElement() {
        Integer[] input = {42};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(42);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(1, 2, 3, 4, 5);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingReverseOrder() {
        Integer[] input = {5, 4, 3, 2, 1};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(1, 2, 3, 4, 5);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingUnsortedArray() {
        Integer[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingWithDuplicates() {
        Integer[] input = {3, 3, 2, 2};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(2, 2, 3, 3);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingNegativeNumbers() {
        Integer[] input = {-5, -1, -10, 0, 5};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(-10, -5, -1, 0, 5);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingMixedNumbers() {
        Integer[] input = {-1, 2, -3, 4, 0};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly(-3, -1, 0, 2, 4);
        assertThat(isSorted(input)).isTrue();
    }

    @Test
    void testSortingMixedCharacters() {
        Character[] input = {'S','O','R','T','E','X','A','M','P','L','E'};
        getSortAlgorithm().sort(input);
        assertThat(input).containsExactly('A','E','E','L','M','O','P','R','S','T','X');
        assertThat(isSorted(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {
        1_250, 2_500, 5_000, 10_000,
        20_000, 40_000, 80_000,
        160_000, // Long to execute
        320_000 // Very long to execute
    })
    @Execution(ExecutionMode.SAME_THREAD)
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
        getSortAlgorithm().sort(input);
        StdOut.println("Performance test with N=" + capacity);
        StdOut.println(watch.elapsedTime() + " sec.\n");

        // Make sure it's sorted
        assertThat(isSorted(input)).isTrue();
    }

}
