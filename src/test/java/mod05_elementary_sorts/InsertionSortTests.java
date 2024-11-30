package mod05_elementary_sorts;

import mod05_elementary_sorts.sandbox.Insertion;
import mod05_elementary_sorts.sandbox.SortAlgorithm;

class InsertionSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Insertion();
    }
}