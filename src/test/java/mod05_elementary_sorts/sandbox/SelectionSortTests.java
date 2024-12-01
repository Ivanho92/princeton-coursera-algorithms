package mod05_elementary_sorts.sandbox;

class SelectionSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Selection();
    }
}