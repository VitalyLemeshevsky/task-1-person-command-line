package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PersonDAO;
import models.Person;

import java.util.Map;
import java.util.Scanner;

public class DisplayListAllPersonsByLastName implements MenuCommand {
    private PersonDAO personDAO;
    private Scanner console;

    public DisplayListAllPersonsByLastName(PersonDAO personDAO, Scanner console) {
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
