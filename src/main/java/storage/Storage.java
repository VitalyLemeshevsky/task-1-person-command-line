package storage;

import dao.PositionDAO;
import models.Person;
import models.Position;

import java.util.HashMap;

public class Storage {
    static int lastIdPositionHashMap = 0;
    static int lastPersonHashMap = 0;

    public static HashMap<Integer, Position> positionHashMap;
    private static HashMap<Integer, Person> personHashMap;

    public static int getLastIdPositionHashMap() {
        return lastIdPositionHashMap;
    }

    public static void setLastIdPositionHashMap(int lastIdPositionHashMap) {
        Storage.lastIdPositionHashMap = lastIdPositionHashMap;
    }
}
