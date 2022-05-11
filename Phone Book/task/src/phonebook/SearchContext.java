package phonebook;

public class SearchContext {
    private SearchStrategy searchStrategy;

    public SearchContext(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void executeSearch(Checklist checklist, Phonebook phoneBook) {
        this.searchStrategy.search(checklist, phoneBook);
    }

    public void setSearchStrategy(SearchStrategy newSearchStrategy) {
        searchStrategy = newSearchStrategy;
    }
}
