package dao;

import models.Person;
import models.Position;

import java.util.Date;
import java.util.HashMap;

public interface PersonDAO {
    public void addPerson(String lastName, String firstName, String patronymic, Position position, boolean signOfDismissal, Date dateOfCreation, Date dateOfModification);
    public HashMap<Integer, Person> getAllPersons();
    public Person getPersonById(int personId);
    public boolean isPersonKey(int personKey);
    public void changePersonDAO(int personId, String lastName, String firstName, String patronymic);
    public HashMap<Integer, Person> getAllPersonsByLastName();
}