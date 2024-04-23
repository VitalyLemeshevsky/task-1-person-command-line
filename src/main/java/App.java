import dao.PositionDAO;
import dao.impl.PositionDAOImpl;
import menuCommand.AddNewPositionCommand;
import menuCommand.DisplayListAllPositions;
import models.Position;

import java.util.Scanner;

public class App {
    private final static Scanner console = new Scanner(System.in);
    private static PositionDAO positionDAO;

    public static void main(String[] args) {
        positionDAO = new PositionDAOImpl();
        new AddNewPositionCommand(new PositionDAOImpl(), console).execute();
        positionDAO = new PositionDAOImpl();
        new AddNewPositionCommand(new PositionDAOImpl(), console).execute();
        new AddNewPositionCommand(new PositionDAOImpl(), console).execute();
        new DisplayListAllPositions(positionDAO).execute();
    }
}