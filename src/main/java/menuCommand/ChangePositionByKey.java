package menuCommand;

import dao.PositionDAO;
import models.Position;
import storage.impl.StorageImpl;

import java.util.HashMap;
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
        String idName = null;
        HashMap<Integer, Position> positionHashMap;
        Position position;

        while (Integer.getInteger(idName) == null) {
            System.out.println("Введите id должности, которую хотите измененить:");
            idName = console.nextLine();

            System.out.println("idName = " + idName);
            System.out.println("Integer.getInteger(idName) = " + Integer.getInteger(idName));

            if (Integer.getInteger(idName) != null && positionDAO.isPositionKey(Integer.parseInt(idName))) {
                System.out.println("Введите другое название должности с id = " + idName);

                positionHashMap = StorageImpl.getPositionHashMap();
                position = positionHashMap.get(Integer.parseInt(idName));
                position.setPositionName(idName);
                positionHashMap.put(Integer.parseInt(idName), position);

            }
        }
    }
}
