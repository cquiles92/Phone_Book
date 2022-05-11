package phonebook;


public class LinearSearch implements SearchStrategy {

    @Override
    public void search(Checklist checklist, Phonebook phonebook) {
        String[] peopleToLookFor = checklist.getNamesOfPeople();
        Person[] peopleInDirectory = phonebook.getPeopleInDirectory();
        int numberFound = 0;

        for (String personName : peopleToLookFor) {
            for (Person person : peopleInDirectory) {
                if (person.getName().equals(personName)) {
                    numberFound++;
                    break;
                }
            }
        }

        System.out.printf("Found %d / %d entries. ", numberFound, checklist.getNumberOfList());
    }
}
