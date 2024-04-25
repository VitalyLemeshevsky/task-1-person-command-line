package menuCommand;

import dao.PositionDAO;

import java.util.Scanner;

public class AddNewPositionCommand implements MenuCommand {
    private PositionDAO positionDAO;
    private Scanner console;

    public AddNewPositionCommand(PositionDAO positionDAO, Scanner console) {
        this.positionDAO = positionDAO;
        this.console = console;
    }

    @Override
    public void execute() {
        String positionName = "";

        while (positionName == "") {
            System.out.println("Введите наименование должности:");
            positionName = console.nextLine();

            if (!positionName.equals("") && positionDAO.isPositionName(positionName)) {
                System.out.println("Внимание! Должность \"" + positionName + "\" уже существует");
                positionName = "";
            }
        }

        positionDAO.addPositionDAO(positionName);
    }
}

