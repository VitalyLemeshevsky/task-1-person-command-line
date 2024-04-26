package dao.impl;

import dao.PersonDAO;
import models.Person;
import models.Position;
import storage.impl.StorageImpl;

import java.util.HashMap;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public void addPerson(String firstName, String lastName, String surname, Position position, boolean signOfDismissal) {
        Person person = new Person();

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setSurname(surname);
        person.setPosition(position);
        person.setSignOfDismissal(signOfDismissal);

        HashMap<Integer, Person> personHashMap = StorageImpl.getPersonHashMap();

    }

    @Override
    public void changePerson() {

    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }
}
