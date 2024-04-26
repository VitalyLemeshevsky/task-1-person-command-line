package storage.impl;

import models.Person;
import models.Position;

import java.util.HashMap;

public class StorageImpl {
    private static int lastIdPositionHashMap = 0;
    static int lastPersonHashMap = 0;

    private static HashMap<Integer, Position> positionHashMap;
    private static HashMap<Integer, Person> personHashMap;

    static {
        positionHashMap = new HashMap<>();
    }

    public static int getLastIdPositionHashMap() {
        return lastIdPositionHashMap;
    }

    public static void setLastIdPositionHashMap(int lastIdPositionHashMap) {
        StorageImpl.lastIdPositionHashMap = lastIdPositionHashMap;
    }

    public static HashMap<Integer, Position> getPositionHashMap() {
        return positionHashMap;
    }

    public static void setPositionHashMap(HashMap<Integer, Position> positionHashMap) {
        StorageImpl.positionHashMap = positionHashMap;
    }

    public static HashMap<Integer, Person> getPersonHashMap() {
        return personHashMap;
    }

    public static void setPersonHashMap(HashMap<Integer, Person> personHashMap) {
        StorageImpl.personHashMap = personHashMap;
    }
}
