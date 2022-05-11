package phonebook;

public class JumpSearch implements SearchStrategy {
    @Override
    public void search(Checklist checklist, Phonebook phonebook) {
        String[] peopleToLookFor = checklist.getNamesOfPeople();
        Person[] peopleInDirectory = phonebook.getPeopleInDirectory();
        int numberFound = 0;

        int block = (int) Math.floor(Math.sqrt(peopleInDirectory.length));

        //for every person in people to look for
        for (String person : peopleToLookFor) {
            int index = 0;
            while (true) {
                String currentName = peopleInDirectory[index].getName();
                //if the name is found
                if (currentName.equals(person)) {
                    numberFound++;
                    break;
                }// if the name is "smaller" go forwards
                else if (person.compareTo(currentName) > 0) {
                    //if at end of list and last element is still smaller
                    if (index == peopleInDirectory.length - 1) {
                        break;
                    }
                    //go ahead either by block or if uneven blocks to the end of array
                    //in order to avoid out of bound exceptions
                    index = Math.min(index + block, peopleInDirectory.length - 1);
                } else {
                    //linear search backwards
                    for (int i = 1; i < block && index - i >= 0; i++) {
                        currentName = peopleInDirectory[index - i].getName();
                        //if we found the element
                        if (person.equals(currentName)) {
                            numberFound++;
                            break;
                        }
                    }
                    //didn't find it and the element is not in the list at all
                    break;
                }
            }
        }

        System.out.printf("Found %d / %d entries. ", numberFound, checklist.getNumberOfList());


    }
}
