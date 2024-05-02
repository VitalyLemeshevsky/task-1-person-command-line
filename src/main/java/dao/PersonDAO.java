package dao;

import models.Person;
import models.Position;

import java.util.Date;

public interface PersonDAO {
    public void addPerson(String lastName, String firstName, String patronymic, Position position, boolean signOfDismissal, Date dateOfCreation, Date dateOfModification);

    public void changePerson();

    public Person getPersonById(int id);
}