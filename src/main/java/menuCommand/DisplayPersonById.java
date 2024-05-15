package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PersonDAO;
import dao.PositionDAO;

import java.util.Scanner;

public class DisplayPersonById implements MenuCommand{
    private PersonDAO personDAO;
    private Scanner console;

    public DisplayPersonById(PersonDAO personDAO, Scanner console) {
        this.personDAO = personDAO;
        this.console = console;
    }
    @Override
    public void execute() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String personId = "";

        while (personId.equals("")) {
            System.out.println("Введите Id должности название которой вы хотите вывести:");
            personId = console.nextLine();
            if (!(personId.matches("[-+]?\\d+") && personDAO.isPersonKey(Integer.parseInt(personId)))) {
                personId = "";
            }
        }
        try {
            System.out.println(mapper.writeValueAsString(personDAO.getPersonById(Integer.parseInt(personId))));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
