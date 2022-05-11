package phonebook;

public class BubbleSortStrategy implements SortStrategy {

    @Override
    public Phonebook sort(Phonebook phonebook) {
        Person[] arrayToSort = phonebook.getPeopleInDirectory();

        for (int i = 0; i < arrayToSort.length - 1; i++) {
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j].getName().compareTo(arrayToSort[j + 1].getName()) > 0) {
                    Person temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }

        return new Phonebook(arrayToSort);
    }

    @Override
    public Phonebook sort(Phonebook phonebook, long timeLimit) {
        Person[] arrayToSort = phonebook.getPeopleInDirectory();
        long currentTime = System.currentTimeMillis();

        for (int i = 0; i < arrayToSort.length - 1; i++) {
            long timeElapsed = System.currentTimeMillis() - currentTime;
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j].getName().compareTo(arrayToSort[j + 1].getName()) > 0) {
                    Person temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
            if (timeElapsed >= timeLimit) {
                return phonebook;
            }
        }

        return new Phonebook(arrayToSort);
    }
}
