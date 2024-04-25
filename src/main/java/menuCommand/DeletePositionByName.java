package menuCommand;

import dao.PositionDAO;

import java.util.Scanner;

public class DeletePositionByName implements MenuCommand {
    private PositionDAO positionDAO;
    private Scanner console;

    public DeletePositionByName(PositionDAO positionDAO, Scanner console) {
        this.positionDAO = positionDAO;
        this.console = console;
    }

    @Override
    public void execute() {
        String positionName = "";

        while (positionName == "") {
            System.out.println("Введите наименование должности для удаления:");
            positionName = console.nextLine();

            if (!positionName.equals("") && !positionDAO.isPositionName(positionName)) {
                System.out.println("Внимание! Должность \"" + positionName + "\" не существует");
                positionName = "";
            }
        }
        positionDAO.deleatePositionByName(positionName);
    }
}
