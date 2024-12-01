package mod05_elementary_sorts.sandbox;

class ShellSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Shell();
    }
}