package phonebook;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// CLASS TO HOLD PEOPLE I'M LOOKING FOR
public class Checklist{
    private final File peopleToSearch;
    private final String[] namesOfPeople;

    public Checklist(File peopleToSearch) {
        this.peopleToSearch = peopleToSearch;
        namesOfPeople = listOfNames();

    }

    private String[] listOfNames() {
        List<String> names = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(peopleToSearch))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                names.add(currentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names.toArray(new String[0]);
    }

    public String[] getNamesOfPeople() {
        return namesOfPeople;
    }

    int getNumberOfList() {
        return namesOfPeople.length;
    }
}
