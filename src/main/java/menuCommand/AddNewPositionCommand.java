package menuCommand;

import dao.PositionDAO;
import models.Position;
import storage.Storage;

import java.util.Collection;
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

            Collection<Position> positions = Storage.positionHashMap.values();
            String finalPositionName = positionName;

            if (!positionName.equals("") && !positionDAO.isPositionName(positionName)) {
                System.out.println("Внимание! Должность \"" + positionName + "\" уже существует");
                positionName = "";
            }

        }

        positionDAO.addPositionDAO(positionName);
    }
}

