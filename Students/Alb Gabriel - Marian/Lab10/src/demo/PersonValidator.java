package demo;

public class PersonValidator {
    public void validate(Person person) throws PersonNotValidException, AddressNotFoundException {
        if (person == null) {
            throw new PersonNotValidException("Person is null");
        }

        if (person.getAddress() == null) {
            throw new AddressNotFoundException("Address is null");
        }
    }
}