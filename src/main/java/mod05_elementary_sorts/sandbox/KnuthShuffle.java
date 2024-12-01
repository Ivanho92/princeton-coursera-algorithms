package mod05_elementary_sorts.sandbox;

import edu.princeton.cs.algs4.StdRandom;

import static mod05_elementary_sorts.sandbox.Utils.swap;

public class KnuthShuffle implements ShuffleAlgorithm {

    @Override
    public <T extends Comparable<T>> void shuffle(T[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int random = StdRandom.uniformInt(i+1);
            swap(array, i, random);
        }
    }
}
