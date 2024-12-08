package mod05_elementary_sorts.sandbox;

class SelectionSortTest extends BaseSortTest {

    @Override
    protected SortAlgorithm getSortAlgorithm() {
        return new Selection();
    }
}