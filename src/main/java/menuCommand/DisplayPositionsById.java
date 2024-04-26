package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PositionDAO;

import java.util.Scanner;

public class DisplayPositionsById implements MenuCommand {
    private PositionDAO positionDAO;
    private Scanner console;

    public DisplayPositionsById(PositionDAO positionDAO, Scanner console) {
        this.positionDAO = positionDAO;
        this.console = console;
    }

    @Override
    public void execute() {
        ObjectMapper mapper = new ObjectMapper();
        String positionId = "";

        while (positionId.equals("")) {
            System.out.println("Введите Id должности название которой вы хотите вывести:");
            positionId = console.nextLine();
            if (!(positionId.matches("[-+]?\\d+") && positionDAO.isPositionKey(Integer.parseInt(positionId)))) {
                positionId = "";
            }
        }
        try {
            System.out.println(mapper.writeValueAsString(positionDAO.getPositionById(Integer.parseInt(positionId))));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
