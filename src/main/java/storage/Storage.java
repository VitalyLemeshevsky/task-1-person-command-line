package storage;

import models.Position;
import storage.impl.StorageImpl;

import java.util.HashMap;
import java.util.Map;

public interface Storage {
    static int lastPersonHashMap = 0;
    static Map positionHashMap = null;

    public static Map getPositionHashMap() {
        return positionHashMap;
    }

    public static void setPositionHashMap(Map positionHashMap) {

    }

}
