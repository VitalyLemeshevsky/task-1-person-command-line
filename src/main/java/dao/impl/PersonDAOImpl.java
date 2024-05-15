package dao.impl;

import dao.PersonDAO;
import models.Person;
import models.Position;
import storage.impl.StorageImpl;

import java.util.Date;
import java.util.HashMap;

public class PersonDAOImpl implements PersonDAO {
    public PersonDAOImpl() {

    }

    @Override
    public void addPerson(String lastName, String firstName, String patronymic, Position position, boolean signOfDismissal, Date dateOfCreation, Date dateOfModification) {
        Person person = new Person();
        StorageImpl.setLastIdPersonHashMap(StorageImpl.getLastIdPersonHashMap() + 1);

        person.setPersonId(StorageImpl.getLastIdPersonHashMap());
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPatronymic(patronymic);
        person.setPosition(position);
        person.setSignOfDismissal(signOfDismissal);
        person.setDateOfCreation(dateOfModification);
        person.setDateOfModification(dateOfModification);

        HashMap<Integer, Person> personHashMap = StorageImpl.getPersonHashMap();
        personHashMap.put(StorageImpl.getLastIdPersonHashMap(), person);
        StorageImpl.setPersonHashMap(personHashMap);
    }

    @Override
    public HashMap<Integer, Person> getAllPersons() {
        return StorageImpl.getPersonHashMap();
    }

    @Override
    public Person getPersonById(int personId) {
        return StorageImpl.getPersonHashMap().get(personId);
    }

    @Override
    public boolean isPersonKey(int personKey) {
        return StorageImpl.getPersonHashMap().containsKey(personKey);
    }

    @Override
    public void changePersonDAO(int personId, String lastName, String firstName, String patronymic) {
        HashMap<Integer, Person> personHashMap;
        Person person;

        personHashMap = StorageImpl.getPersonHashMap();
        person = getPersonById(personId);
        person.setLastName(lastName);
        person.setFirstName(firstName);
        person.setPatronymic(patronymic);
        person.setDateOfModification(new Date());

        personHashMap.put(personId, person);
    }

    @Override
    public HashMap<Integer, Person> getAllPersonsByLastName() {

        return null;
    }


}
