package mod05_elementary_sorts.sandbox;

public interface SortAlgorithm {
    <T extends Comparable<T>> void sort(T[] array);
}
