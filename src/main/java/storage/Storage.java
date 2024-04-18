package storage;

import dao.PositionDAO;
import models.Person;

import java.util.HashMap;

public class Storage {
    static int lastIdPositionHashMap = 0;
    static int lastPersonHashMap = 0;

    static HashMap<Integer, PositionDAO> positionHashMap;
    static HashMap<Integer, Person> personHashMap;
}
