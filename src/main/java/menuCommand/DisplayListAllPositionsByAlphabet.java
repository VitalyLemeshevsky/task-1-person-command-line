package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.PositionDAO;

public class DisplayListAllPositionsByAlphabet implements MenuCommand{
    private PositionDAO positionDAO;

    public DisplayListAllPositionsByAlphabet(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }
    @Override
    public void execute() throws JsonProcessingException {

    }
}
