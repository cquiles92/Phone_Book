package phonebook;


public class BinarySearch implements SearchStrategy {
    @Override
    public void search(Checklist checklist, Phonebook phonebook) {
        String[] listOfPeople = checklist.getNamesOfPeople();
        int numberFound = 0;

        for (String person : listOfPeople) {
            numberFound += findPerson(person, phonebook);
        }

        System.out.printf("Found %d / %d entries. ", numberFound, checklist.getNumberOfList());
    }

    private int findPerson(String person, Phonebook phonebook) {
        Person[] directory = phonebook.getPeopleInDirectory();
        int left = 0;
        int right = directory.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            String currentName = directory[mid].getName();
            if (currentName.equals(person)) {
                return 1;
            } else if (person.compareTo(currentName) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }


}
