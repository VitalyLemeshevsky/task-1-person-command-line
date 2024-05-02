package dao.impl;

import dao.PersonDAO;
import models.Person;
import models.Position;
import storage.impl.StorageImpl;

import java.util.Date;
import java.util.HashMap;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public void addPerson(String lastName, String firstName, String patronymic, Position position, boolean signOfDismissal, Date dateOfCreation, Date dateOfModification) {
        Person person = new Person();

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPatronymic(patronymic);
        person.setPosition(position);
        person.setSignOfDismissal(signOfDismissal);
        person.setDateOfCreation(dateOfModification);
        person.setDateOfModification(dateOfModification);

        HashMap<Integer, Person> personHashMap = StorageImpl.getPersonHashMap();
        //personHashMap.put();
    }

    @Override
    public void changePerson() {

    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }
}
