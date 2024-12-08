package mod05_elementary_sorts.sandbox;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.SAME_THREAD)
class ShuffleSortTest {

    private final ShuffleAlgorithm shuffleSort = new ShuffleSort();

    @BeforeEach
    void setSeed() {
        StdRandom.setSeed(100);
    }

    @Test
    void shuffleShouldRandomizeArray() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffleSort.shuffle(array);
        assertThat(array).containsExactly(3, 7, 1, 4, 5, 6, 8, 9, 2, 10);
    }

    @Test
    void shuffleShouldNotAlterEmptyArray() {
        Integer[] array = {};
        shuffleSort.shuffle(array);
        assertThat(array).isEmpty();
    }

    @Test
    void shuffleShouldNotAlterSingleElementArray() {
        Integer[] array = {42};
        shuffleSort.shuffle(array);
        assertThat(array).containsExactly(42);
    }

    @Test
    void shuffleShouldPerformEfficientlyForLargeArrays() {
        int n = 10_000_000;
        Integer[] largeArray = new Integer[n];
        for (int i = 0; i < n; i++)
            largeArray[i] = i;

        Stopwatch watch = new Stopwatch();
        shuffleSort.shuffle(largeArray);
        StdOut.println("Performance test with N=" + n);
        StdOut.println(watch.elapsedTime() + " sec.\n");

        assertThat(watch.elapsedTime()).isLessThan(10); // less than 10 seconds
    }
}
