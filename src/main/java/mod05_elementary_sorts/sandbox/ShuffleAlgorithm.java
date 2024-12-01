package mod05_elementary_sorts.sandbox;

public interface ShuffleAlgorithm {
    <T extends Comparable<T>> void shuffle(T[] array);
}
