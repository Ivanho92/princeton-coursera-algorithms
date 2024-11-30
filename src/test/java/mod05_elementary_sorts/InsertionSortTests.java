package mod05_elementary_sorts;

import mod05_elementary_sorts.sandbox.Insertion;

class InsertionSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return Insertion::sort;
    }
}