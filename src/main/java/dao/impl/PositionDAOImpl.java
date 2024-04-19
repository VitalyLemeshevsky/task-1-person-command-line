package dao.impl;

import dao.PositionDAO;
import models.Position;
import storage.Storage;

import java.util.HashMap;

public class PositionDAOImpl implements PositionDAO {
    Position position = new Position();

    @Override
    public void addPositionDAO(String positionName) {
        Storage.setLastIdPositionHashMap(Storage.getLastIdPositionHashMap() + 1);

        position.setPositionId(Storage.getLastIdPositionHashMap());
        position.setPositionName(positionName);

//         Storage.positionHashMap.put(Storage.getLastIdPositionHashMap() + 1, (PositionDAO) position);
    }

    @Override
    public void changePositionDAO() {

    }

    @Override
    public HashMap<Integer, Position> getAllPositions() {
        return Storage.positionHashMap;
    }
}
