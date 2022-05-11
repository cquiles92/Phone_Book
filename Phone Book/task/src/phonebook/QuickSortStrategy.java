package phonebook;

import java.util.Random;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public Phonebook sort(Phonebook phonebook) {
        Person[] arrayToSort = phonebook.getPeopleInDirectory();

        quickSort(arrayToSort);

        return new Phonebook(arrayToSort);
    }

    @Override
    public Phonebook sort(Phonebook phonebook, long timeLimit) {
        Person[] arrayToSort = phonebook.getPeopleInDirectory();

        quickSort(arrayToSort, timeLimit);

        return new Phonebook(arrayToSort);
    }

    private void quickSort(Person[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(Person[] arrayToSort, long timeLimit) {
        quickSort(arrayToSort, arrayToSort.length - 1, timeLimit);
    }

    private void quickSort(Person[] arr, int lowIndex, int highIndex) {
        //if inner array = size 1
        if (lowIndex >= highIndex) {
            return;
        }

        //pivot from the median
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        Person pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private void quickSort(Person[] arr, int highIndex, long timeLimit) {
        //if inner array = size 1
        if (0 >= highIndex) {
            return;
        }

        //time code
        long timeElapsed = System.currentTimeMillis();
        if (timeElapsed >= timeLimit) {
            return;
        }

        //pivot from the median
        int pivotIndex = new Random().nextInt(highIndex);
        Person pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPointer = partition(arr, 0, highIndex, pivot);

        quickSort(arr, 0, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private int partition(Person[] arr, int lowIndex, int highIndex, Person pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer].getName().compareTo(pivot.getName()) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer].getName().compareTo(pivot.getName()) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }

    private void swap(Person[] arr, int firstIndex, int secondIndex) {
        Person temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
