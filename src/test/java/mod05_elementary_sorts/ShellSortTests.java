package mod05_elementary_sorts;

import mod05_elementary_sorts.sandbox.Shell;
import mod05_elementary_sorts.sandbox.SortAlgorithm;

class ShellSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Shell();
    }
}