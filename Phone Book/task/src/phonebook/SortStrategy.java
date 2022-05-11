package phonebook;

public interface SortStrategy {
    //sort directory file
    Phonebook sort(Phonebook phonebook);

    //timeLimit enforces the method to return the original value if time exceeds limit
    Phonebook sort(Phonebook phonebook, long timeLimit);

}
