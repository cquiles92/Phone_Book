package phonebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashManager {
    HashSet<String> listOfPeople;
    HashMap<String, Person> directory;


    public HashManager(Checklist listOfPeople, Phonebook directory) {
        this.listOfPeople = createListOfPeopleAsHashSet(listOfPeople);
        this.directory = createDirectoryAsHashMap(directory);
    }

    public void search() {
        int numberFound = 0;
        for (String name : listOfPeople) {
            if (directory.containsKey(name)) {
                numberFound++;
            }
        }

        System.out.printf("Found %d / %d entries. ", numberFound, listOfPeople.size());
    }

    private HashSet<String> createListOfPeopleAsHashSet(Checklist listOfPeople) {
        return new HashSet<>(List.of(listOfPeople.getNamesOfPeople()));
    }

    private HashMap<String, Person> createDirectoryAsHashMap(Phonebook directory) {
        HashMap<String, Person> directoryAsHash = new HashMap<>();
        Person[] listOfPeople = directory.getPeopleInDirectory();

        for (Person person : listOfPeople) {
            directoryAsHash.put(person.getName(), person);
        }

        return directoryAsHash;
    }
}
