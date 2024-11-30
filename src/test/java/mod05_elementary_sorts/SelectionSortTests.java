package mod05_elementary_sorts;

import mod05_elementary_sorts.sandbox.Selection;
import mod05_elementary_sorts.sandbox.SortAlgorithm;

class SelectionSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Selection();
    }
}