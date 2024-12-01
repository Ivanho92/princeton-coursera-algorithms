package mod05_elementary_sorts.sandbox;

class InsertionSortTests extends BaseSortTests {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Insertion();
    }
}