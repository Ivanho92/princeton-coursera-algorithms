package mod05_elementary_sorts.sandbox;

class InsertionSortTest extends BaseSortTest {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Insertion();
    }
}