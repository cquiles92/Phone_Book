package phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//CLASS TO HOLD CONTENTS OF MAIN DIRECTORY TO SEARCH THROUGH
public class Phonebook {
    private final Person[] peopleInDirectory;

    public Phonebook(File directoryFile) {
        peopleInDirectory = populateDirectory(directoryFile);
    }

    public Phonebook(Person[] listOfPeople) {
        peopleInDirectory = listOfPeople;
    }

    private Person[] populateDirectory(File directoryFile) {
        List<Person> directory = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(directoryFile))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                int index = currentLine.indexOf(" ");//split on the very first space
                int phoneNumber = Integer.parseInt(currentLine.substring(0, index));
                String name = currentLine.substring(index).strip();
                directory.add(new Person(phoneNumber, name));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return directory.toArray(new Person[0]);
    }

    public Person[] getPeopleInDirectory() {
        return peopleInDirectory;
    }

}
