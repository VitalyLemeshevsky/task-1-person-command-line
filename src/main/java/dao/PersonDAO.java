package dao;

import models.Person;
import models.Position;

import java.util.Date;

public interface PersonDAO {
public void addPerson(String firstName, String lastName, String surname, Position position, boolean signOfDismissal);
public void changePerson();
public Person getPersonById(int id);
}