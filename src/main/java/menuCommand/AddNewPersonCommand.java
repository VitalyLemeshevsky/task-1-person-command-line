package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PersonDAO;
import dao.PositionDAO;
import models.Person;
import models.Position;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class AddNewPersonCommand implements MenuCommand {
    private PersonDAO personDAO;
    PositionDAO positionDAO;
    private Scanner console;

    private final static String regexForSignOfDismissal = "^([0-1])$";
    private final static String regexForInteger = "[0-9]+";

    public AddNewPersonCommand(PersonDAO personDAO, PositionDAO positionDAO, Scanner console) {
        this.personDAO = personDAO;
        this.positionDAO = positionDAO;
        this.console = console;
    }

    @Override
    public void execute() {
        String lastName = enterTextValueOfField("Введите фамилию нового сотрудника:");
        String firstName = enterTextValueOfField("Введите имя нового сотрудника:");
        String patronymic = enterTextValueOfField("Введите отчество нового сотрудника:");
        boolean signOfDismissal = enterBooleanValueOfField("Введите признак уволнения (0-уволен, 1 работает)");
        Date date = new Date();

        Position position = selectPosition("Выберите код из следующих должностей:");

        personDAO.addPerson(lastName, firstName, patronymic, position, signOfDismissal, date, date);
    }

    String enterTextValueOfField(String title) {
        String fieldValue = "";

        while (fieldValue == "") {
            System.out.println(title);
            fieldValue = console.nextLine();
        }
        return fieldValue;
    }

    boolean enterBooleanValueOfField(String title) {
        String fieldValue = "";

        while (fieldValue.matches(regexForSignOfDismissal)) {
            System.out.println(title);
            fieldValue = console.nextLine();
        }
        if (fieldValue.equals("1")) {
            return true;
        }
        return false;
    }

    Position selectPosition(String title) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        String fieldValue = "";

        while (fieldValue.equals("")) {
            System.out.println(title);
            for (Map.Entry<Integer, Position> position : positionDAO.getAllPositions().entrySet()) {
                System.out.println(position.getKey() + " " + position.getValue().getPositionName());
                try {
                    json = mapper.writeValueAsString(position.getValue());
                    System.out.println("json = " + json);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            fieldValue = console.nextLine();
            if (!(fieldValue.matches("[-+]?\\d+") && positionDAO.isPositionKey(Integer.parseInt(fieldValue)))) {
                fieldValue = "";
            }
        }
        return positionDAO.getPositionById(Integer.parseInt(fieldValue));
    }
}
