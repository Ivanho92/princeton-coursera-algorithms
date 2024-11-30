package mod05_elementary_sorts;

import mod05_elementary_sorts.sandbox.Selection;

class SelectionSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return Selection::sort;
    }
}