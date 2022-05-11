package phonebook;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final int phoneNumber;
    private final String name;

    public Person(int phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, name);
    }
}
