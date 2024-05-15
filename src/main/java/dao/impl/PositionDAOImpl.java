package dao.impl;

import dao.PositionDAO;
import models.Position;
import storage.impl.StorageImpl;

import java.util.HashMap;

public class PositionDAOImpl implements PositionDAO {
    public PositionDAOImpl() {}

    @Override
    public void addPositionDAO(String positionName) {
        Position position = new Position();
        StorageImpl.setLastIdPositionHashMap(StorageImpl.getLastIdPositionHashMap() + 1);

        position.setPositionId(StorageImpl.getLastIdPositionHashMap());
        position.setPositionName(positionName);

        HashMap<Integer, Position> positionHashMap = StorageImpl.getPositionHashMap();
        positionHashMap.put(StorageImpl.getLastIdPositionHashMap(), position);
        StorageImpl.setPositionHashMap(positionHashMap);
    }

    @Override
    public boolean isPositionName(String positionName) {
        return !StorageImpl.getPositionHashMap().values().stream().filter(position -> position.getPositionName().equals(positionName)).findFirst().isEmpty();
    }

    @Override
    public boolean isPositionKey(int positionKey) {
        return StorageImpl.getPositionHashMap().containsKey(positionKey);
    }

    @Override
    public void deleatePositionByName(String positionName) {
        HashMap<Integer, Position> positionHashMap = StorageImpl.getPositionHashMap();
        positionHashMap.remove(getPositionByName(positionName).getPositionId());
        StorageImpl.setPositionHashMap(positionHashMap);
    }

    @Override
    public HashMap<Integer, Position> getAllPositions() {
        return StorageImpl.getPositionHashMap();
    }

    @Override
    public void changePositionDAO(int positionId, String positionName) {
        HashMap<Integer, Position> positionHashMap;
        Position position;

        positionHashMap = StorageImpl.getPositionHashMap();
        position = getPositionById(positionId);
        position.setPositionName(positionName);

        positionHashMap.put(positionId, position);
    }

    @Override
    public Position getPositionByName(String positionName) {
        return StorageImpl.getPositionHashMap().values().stream().filter(position -> position.getPositionName().equals(positionName)).findFirst().get();
    }

    @Override
    public Position getPositionById(Integer positionId) {
        return StorageImpl.getPositionHashMap().get(positionId);
    }

}
