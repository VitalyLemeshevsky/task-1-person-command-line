import dao.PositionDAO;
import dao.impl.PositionDAOImpl;
import menuCommand.AddNewPositionCommand;
import models.Position;

import java.util.Scanner;

public class App {
    private final static Scanner console = new Scanner(System.in);
    private static PositionDAO positionDAO;
    public static void main(String[] args) {
        positionDAO = new PositionDAOImpl();
       new AddNewPositionCommand(positionDAO, console).execute();
    }
}