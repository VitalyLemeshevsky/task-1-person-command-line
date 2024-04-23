package menuCommand;

import dao.PositionDAO;
import models.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DisplayListAllPositions implements MenuCommand {
    private PositionDAO positionDAO;

    public DisplayListAllPositions(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Override
    public void execute() {
        HashMap<Integer, Position> positionHashMap = positionDAO.getAllPositions();

        for (Map.Entry<Integer, Position> position : positionHashMap.entrySet()) {
            System.out.println(position.getKey() + " " + position.getValue().getPositionName());
        }

    }
}