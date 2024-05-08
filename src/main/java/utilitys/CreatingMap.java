package utilitys;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.PersonDAOImpl;
import dao.impl.PositionDAOImpl;
import menuCommand.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatingMap {
    private Map<Integer, MenuCommand> menuCommandsMap;

    public CreatingMap() {
        this.menuCommandsMap = new HashMap<>();

        menuCommandsMap.put(1, new AddNewPositionCommand(new PositionDAOImpl(), new Scanner(System.in)));
        menuCommandsMap.put(2, new ChangePositionByKey(new PositionDAOImpl(), new Scanner(System.in)));
        menuCommandsMap.put(3, new DeletePositionByName(new PositionDAOImpl(), new Scanner(System.in)));
        menuCommandsMap.put(4, new DisplayPositionsById(new PositionDAOImpl(), new Scanner(System.in)));
        menuCommandsMap.put(5, new DisplayListAllPositions(new PositionDAOImpl()));
        menuCommandsMap.put(6, new AddNewPersonCommand(new PersonDAOImpl(), new PositionDAOImpl(), new Scanner(System.in)));
        menuCommandsMap.put(9, new DisplayListAllPersons(new PersonDAOImpl(), new Scanner(System.in)));
    }

    public void execute(int valueInt) {
        try {
            menuCommandsMap.get(valueInt).execute();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
