package dao;

import models.Person;

public interface PersonDAO {
public void addPerson();
public void changePerson();
public Person getPersonById(int id);
}
