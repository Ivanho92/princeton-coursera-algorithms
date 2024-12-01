package mod05_elementary_sorts.sandbox;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

import static mod05_elementary_sorts.sandbox.Utils.swap;

public class ShuffleSort implements ShuffleAlgorithm {

    @Override
    public <T extends Comparable<T>> void shuffle(T[] array) {
        int n = array.length;
        double[] randoms = new double[n];
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            randoms[i] = StdRandom.uniformDouble();
            indices[i] = i;
        }

        // Uses merge sort
        Arrays.sort(indices, Comparator.comparingDouble(i -> randoms[i]));

        for (int i = 0; i < n; i++)
            swap(array, i, indices[i]);
    }
}
