package mod05_elementary_sorts.exercises;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static mod05_elementary_sorts.exercises.DutchNationalFlag.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DutchNationalFlagTest {

    @Test
    void testAlreadySorted() {
        int[] buckets = {RED, RED, WHITE, WHITE, BLUE, BLUE};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(RED, RED, WHITE, WHITE, BLUE, BLUE);
    }

    @Test
    void testReverseSorted() {
        int[] buckets = {BLUE, BLUE, WHITE, WHITE, RED, RED};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(RED, RED, WHITE, WHITE, BLUE, BLUE);
    }

    @Test
    void testMixedColors() {
        int[] buckets = {WHITE, RED, BLUE, RED, WHITE, BLUE};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(RED, RED, WHITE, WHITE, BLUE, BLUE);
    }

    @Test
    void testSingleColorRed() {
        int[] buckets = {RED, RED, RED};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(RED, RED, RED);
    }

    @Test
    void testSingleColorWhite() {
        int[] buckets = {WHITE, WHITE, WHITE};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(WHITE, WHITE, WHITE);
    }

    @Test
    void testSingleColorBlue() {
        int[] buckets = {BLUE, BLUE, BLUE};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(BLUE, BLUE, BLUE);
    }

    @Test
    void testEmptyArray() {
        int[] buckets = {};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).isEmpty();
    }

    @Test
    void testOneElementArray() {
        int[] buckets = {RED};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(RED);
    }

    @Test
    void testTwoElementArray() {
        int[] buckets = {BLUE, RED};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();
        assertThat(buckets).containsExactly(RED, BLUE);
    }

    @Test
    void testIllegalInput() {
        int[] buckets = {RED, 3};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        assertThat(assertThrows(IllegalArgumentException.class, dnf::sort)).hasMessage(null);
    }

    @Test
    void testSortMethodDoesNotExceedCallLimits() {
        int[] buckets = {RED, BLUE, WHITE, RED};
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);
        dnf.sort();

        assertThat(dnf.callsColor())
                .as("color() should not be called more than n times")
                .isLessThanOrEqualTo(buckets.length);

        assertThat(dnf.callsSwap())
                .as("swap() should not be called more than n times")
                .isLessThanOrEqualTo(buckets.length);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            1_250, 2_500, 5_000, 10_000,
            20_000, 40_000, 80_000,
            160_000, // Long to execute
            320_000 // Very long to execute
    })
    @Execution(ExecutionMode.SAME_THREAD)
    void testSortingPerformance(int capacity) {
        // Given
        int[] buckets = new int[capacity];
        for (int i = 0; i < capacity; i++)
            buckets[i] = StdRandom.uniformInt(3);
        DutchNationalFlag dnf = new DutchNationalFlag(buckets);

        // Print out performance
        Stopwatch watch = new Stopwatch();
        dnf.sort();
        StdOut.println("Performance test with N=" + capacity);
        StdOut.println(watch.elapsedTime() + " sec.\n");

        // Assert performance
        assertThat(watch.elapsedTime()).isLessThanOrEqualTo(1); // 1 second
    }
}
