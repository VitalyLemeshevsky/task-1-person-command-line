package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.PersonDAO;
import dao.PositionDAO;
import models.Person;

import java.util.Map;
import java.util.Scanner;

public class DisplayAllPersonsByPerson implements MenuCommand{
    private PersonDAO personDAO;
    PositionDAO positionDAO;
    private Scanner console;

    public DisplayAllPersonsByPerson(PersonDAO personDAO, PositionDAO positionDAO, Scanner console) {
        this.personDAO = personDAO;
        this.positionDAO = positionDAO;
        this.console = console;
    }
    @Override
    public void execute() throws JsonProcessingException {
        if (personDAO.getAllPersons().isEmpty()) {
            System.out.println("Список сотрудников пуст.");
        } else {

//            for (Map.Entry<Integer, Person> person : personDAO.getAllPersons().entrySet()) {
//                try {
//                    json = mapper.writeValueAsString(person.getValue());
//                    System.out.println("json = "+json);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
    }
}
