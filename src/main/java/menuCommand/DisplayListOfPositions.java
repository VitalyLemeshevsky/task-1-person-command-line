package menuCommand;

import dao.PositionDAO;
import models.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DisplayListOfPositions implements MenuCommand {
    private PositionDAO positionDAO;
    private Scanner console;

    public DisplayListOfPositions(PositionDAO positionDAO, Scanner console) {
        this.positionDAO = positionDAO;
        this.console = console;
    }

    @Override
    public void execute() {
        HashMap<Integer, Position> positionHashMap = positionDAO.getAllPositions();

        //positionHashMap.forEach(position->System.out.println(position.));
        // for (Map.Entry<Integer, Position> position : positionHashMap.entrySet()) {
       //System.out.println(position.getKey(), position.getValue().g);
        }
    }
