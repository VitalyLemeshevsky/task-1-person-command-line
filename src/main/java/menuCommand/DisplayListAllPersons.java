package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PersonDAO;
import dao.PositionDAO;
import models.Person;
import models.Position;

import java.util.Map;
import java.util.Scanner;

public class DisplayListAllPersons implements MenuCommand {
    private PersonDAO personDAO;
    private Scanner console;

    public DisplayListAllPersons(PersonDAO personDAO, Scanner console) {
        this.personDAO = personDAO;
        this.console = console;
    }

    @Override
    public void execute() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        if (personDAO.getAllPersons().isEmpty()) {
            System.out.println("Список сотрудников пуст.");
        } else {

            for (Map.Entry<Integer, Person> person : personDAO.getAllPersons().entrySet()) {
                System.out.println(person.getKey() + " " + person.getValue().getLastName());
                try {
                    json = mapper.writeValueAsString(person.getValue());
                    System.out.println("json = "+json);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
