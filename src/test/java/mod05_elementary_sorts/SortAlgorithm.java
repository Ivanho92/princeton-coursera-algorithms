package mod05_elementary_sorts;

public interface SortAlgorithm {
    <T extends Comparable<T>> void sort(T[] array);
}
