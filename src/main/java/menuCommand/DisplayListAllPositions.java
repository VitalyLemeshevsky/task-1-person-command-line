package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PositionDAO;
import models.Position;

import java.util.Map;

public class DisplayListAllPositions implements MenuCommand {
    private PositionDAO positionDAO;

    public DisplayListAllPositions(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Override
    public void execute() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        if (positionDAO.getAllPositions().isEmpty()) {
            System.out.println("Список должностей пуст.");
        } else {

            for (Map.Entry<Integer, Position> position : positionDAO.getAllPositions().entrySet()) {
                System.out.println(position.getKey() + " " + position.getValue().getPositionName());
                try {
                     json = mapper.writeValueAsString(position.getValue());
                    System.out.println("json = "+json);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
