package phonebook;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File peopleToFindFile = new File("F:\\zzz\\JAVA\\Java Projects\\Phone Book\\find.txt");
        File directoryFile = new File("F:\\zzz\\JAVA\\Java Projects\\Phone Book\\directory.txt");

        SearchProgram searchProgram = new SearchProgram(peopleToFindFile, directoryFile);
        searchProgram.start();

    }
}
