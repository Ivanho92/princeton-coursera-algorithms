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
class KnuthShuffleTests {

    private final KnuthShuffle knuthShuffle = new KnuthShuffle();

    @BeforeEach
    void setSeed() {
        StdRandom.setSeed(100);
    }

    @Test
    void shuffleShouldRandomizeArray() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        knuthShuffle.shuffle(array);
        assertThat(array).containsExactly(6, 5, 8, 10, 3, 1, 2, 9, 4, 7);
    }

    @Test
    void shuffleShouldNotAlterEmptyArray() {
        Integer[] array = {};
        knuthShuffle.shuffle(array);
        assertThat(array).isEmpty();
    }

    @Test
    void shuffleShouldNotAlterSingleElementArray() {
        Integer[] array = {42};
        knuthShuffle.shuffle(array);
        assertThat(array).containsExactly(42);
    }

    @Test
    void shuffleShouldPerformEfficientlyForLargeArrays() {
        int n = 10_000_000;
        Integer[] largeArray = new Integer[n];
        for (int i = 0; i < n; i++)
            largeArray[i] = i;

        Stopwatch watch = new Stopwatch();
        knuthShuffle.shuffle(largeArray);
        StdOut.println("Performance test with N=" + n);
        StdOut.println(watch.elapsedTime() + " sec.\n");

        assertThat(watch.elapsedTime()).isLessThan(3); // less than 3 seconds
    }
}
