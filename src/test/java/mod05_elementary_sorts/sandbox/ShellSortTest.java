package mod05_elementary_sorts.sandbox;

class ShellSortTest extends BaseSortTest {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Shell();
    }
}