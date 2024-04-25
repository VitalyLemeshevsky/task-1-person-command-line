package menuCommand;

import dao.PositionDAO;

import java.util.Scanner;

public class ChangePositionByKey implements MenuCommand {
    private PositionDAO positionDAO;
    private Scanner console;

    public ChangePositionByKey(PositionDAO positionDAO, Scanner console) {
        this.positionDAO = positionDAO;
        this.console = console;
    }

    @Override
    public void execute() {
        String positionId = null;
        String positionName = "";

        while (positionId == null) {
            System.out.println("Введите id должности, которую хотите измененить:");
            positionId = console.nextLine();

            if (positionId.matches("[-+]?\\d+") && positionDAO.isPositionKey(Integer.parseInt(positionId))) {
                while (positionName.equals("")) {
                    System.out.println("Введите другое название должности с id = " + positionId);

                    positionName = console.nextLine();
                    if (!positionName.equals("") && positionDAO.isPositionName(positionName)) {
                        System.out.println("Внимание! Должность \"" + positionName + "\" уже существует");
                        positionName = "";
                    }
                }
                positionDAO.changePositionDAO(Integer.parseInt(positionId), positionName);
            } else {
                positionId = null;
            }
        }
    }
}
