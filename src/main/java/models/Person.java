package models;

import java.util.Date;
import java.util.Objects;

public class Person {
    /*
        Id
    •	Дата создания
    •	Дата изменения
    •	Фамилия
    •	Имя
    •	Отчество
    •	Должность
    •	Признак увольнения
     */
    int personId;
    private Date dateOfCreation;
    private Date dateOfModification;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Position position;
    private boolean signOfDismissal;

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public Person setPersonId(int personId) {
        this.personId = personId;
        return this;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public Person setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
        return this;
    }

    public Date dateOfModification() {
        return dateOfModification;
    }

    public Person setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Person setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Person setPosition(Position position) {
        this.position = position;
        return this;
    }

    public boolean isSignOfDismissal() {
        return signOfDismissal;
    }

    public Person setSignOfDismissal(boolean signOfDismissal) {
        this.signOfDismissal = signOfDismissal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId && signOfDismissal == person.signOfDismissal && Objects.equals(dateOfCreation, person.dateOfCreation) && Objects.equals(dateOfModification, person.dateOfModification) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(patronymic, person.patronymic) && Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, dateOfCreation, dateOfModification, firstName, lastName, patronymic, position, signOfDismissal);
    }
}

