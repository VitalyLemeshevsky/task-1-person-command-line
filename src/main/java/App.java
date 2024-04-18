import dao.PositionDAO;
import dao.impl.PositionDAOImpl;
import menuCommand.AddNewPositionCommand;
import models.Position;

import java.util.Scanner;

public class App {
    private static Scanner console = new Scanner(System.in);
    private Position position;
    public static void main(String[] args) {
        PositionDAO positionDAO = new PositionDAOImpl();
       new AddNewPositionCommand(positionDAO, console);
    }
}