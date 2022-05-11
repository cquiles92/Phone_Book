package phonebook;

import java.io.File;

public class SearchProgram {
    private final Checklist listOfPeople;
    private final Phonebook directory;
    private final SearchContext searchContext;


    public SearchProgram(File listOfPeople, File dataSource) {
        this.listOfPeople = new Checklist(listOfPeople);
        this.directory = new Phonebook(dataSource);
        this.searchContext = new SearchContext(null);
    }

    public void start() {
        long timeLimit;

        //Linear Search
        {
            SearchStrategy searchStrategy = new LinearSearch();
            long timeElapsed = System.currentTimeMillis();

            searchContext.setSearchStrategy(searchStrategy);
            System.out.println("Start searching (linear search)...");
            searchContext.executeSearch(listOfPeople, directory);
            timeElapsed = Math.abs(System.currentTimeMillis() - timeElapsed);
            System.out.println("Time taken: " + printTimeTaken(timeElapsed));
            timeLimit = timeElapsed * 10;
        }

        System.out.println();

        //bubble sort + jump search
        {
            SortStrategy sortStrategy = new BubbleSortStrategy();
            SearchStrategy searchStrategy = new JumpSearch();
            long sortTime = System.currentTimeMillis();

            System.out.println("Start searching (bubble sort + jump search)...");
            Phonebook bubbleSortedDirectory = sortStrategy.sort(directory, timeLimit);
            sortTime = Math.abs(System.currentTimeMillis() - sortTime);
            searchAndSortProcedure(sortTime, bubbleSortedDirectory, searchStrategy);
        }

        System.out.println();

        //quicksort + linear search
        {
            SortStrategy sortStrategy = new QuickSortStrategy();
            SearchStrategy searchStrategy = new BinarySearch();
            long sortTime = System.currentTimeMillis();

            System.out.println("Start searching (quick sort + binary search)...");
            Phonebook quickSortedDirectory = sortStrategy.sort(directory);
            sortTime = Math.abs(System.currentTimeMillis() - sortTime);
            searchAndSortProcedure(sortTime, quickSortedDirectory, searchStrategy);
        }
        System.out.println();

        //Hash
        {
            System.out.println("Start searching (hash table)...");
            long searchTime;
            long createTime = System.currentTimeMillis();

            HashManager hashManager = new HashManager(listOfPeople, directory);
            createTime = Math.abs(createTime - System.currentTimeMillis());
            searchTime = System.currentTimeMillis();
            hashManager.search();
            searchTime = Math.abs(System.currentTimeMillis() - searchTime);

            System.out.println("Time taken: " + printTimeTaken(createTime + searchTime));
            System.out.println("Creating time: " + printTimeTaken(createTime));
            System.out.println("Searching time: " + printTimeTaken(searchTime));
        }
    }

    private void searchAndSortProcedure(long sortTime, Phonebook sortedDirectory, SearchStrategy searchStrategy) {
        long searchTime;
        //if the given directory is sorted
        if (sortedDirectory != directory) {
            searchContext.setSearchStrategy(searchStrategy);
            searchTime = System.currentTimeMillis();
            searchContext.executeSearch(listOfPeople, sortedDirectory);
        } //sort was terminated early and linear search is being called
        else {
            searchContext.setSearchStrategy(new LinearSearch());
            searchTime = System.currentTimeMillis();
            searchContext.executeSearch(listOfPeople, directory);
        }
        searchTime = Math.abs(System.currentTimeMillis() - searchTime);
        System.out.println("Time taken: " + printTimeTaken(sortTime + searchTime));
        System.out.print("Sorting time: " + printTimeTaken(sortTime));
        if (sortedDirectory == directory) {
            System.out.println("  - STOPPED, moved to linear search");
        } else {
            System.out.println();
        }
        System.out.println("Searching time: " + printTimeTaken(searchTime));
    }

    private static String printTimeTaken(long timeTaken) {
        int milliseconds = (int) timeTaken % 1000;
        timeTaken /= 1000;
        int seconds = (int) timeTaken % 60;
        timeTaken /= 60;
        int minutes = (int) timeTaken % 60;

        return String.format("%d min. %d sec. %d ms.", minutes, seconds, milliseconds);
    }
}
