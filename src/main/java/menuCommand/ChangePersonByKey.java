package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.PersonDAO;
import dao.PositionDAO;
import utilitys.PersonCard;

import java.util.Scanner;

public class ChangePersonByKey implements MenuCommand{
    private PersonDAO personDAO;
    private Scanner console;

    public ChangePersonByKey(PersonDAO personDAO, Scanner console) {
        this.personDAO = personDAO;
        this.console = console;
    }
    @Override
    public void execute() throws JsonProcessingException {
        PersonCard personCard = new PersonCard(console);

        String personId = null;
        String lastName = "";
        String firstName = "";
        String patronymic = "";

        while (personId == null) {
            System.out.println("Введите id сотрудника, которого хотите измененить:");
            personId = console.nextLine();
            if (!((personId.matches("[-+]?\\d+") && personDAO.isPersonKey(Integer.parseInt(personId))))) {
                personId = null;
            }
        }

        lastName = personCard.enterTextValueOfField("Введите новую фамилию:");
        firstName = personCard.enterTextValueOfField("Введите новое имя:");
        patronymic = personCard.enterTextValueOfField("Введите новое отчество:");

        personDAO.changePersonDAO(Integer.parseInt(personId), lastName, firstName, patronymic);

    }
}
