package dao.impl;

import dao.PositionDAO;
import models.Position;
import storage.impl.StorageImpl;

import java.util.HashMap;

public class PositionDAOImpl implements PositionDAO {
    public PositionDAOImpl() {

    }

    @Override
    public void addPositionDAO(String positionName) {
        Position position = new Position();
        StorageImpl.setLastIdPositionHashMap(StorageImpl.getLastIdPositionHashMap() + 1);

        position.setPositionId(StorageImpl.getLastIdPositionHashMap());
        position.setPositionName(positionName);

//        Storage.positionHashMap.put(Storage.getLastIdPositionHashMap(), position);
        HashMap<Integer, Position> positionHashMap = StorageImpl.getPositionHashMap();
        positionHashMap.put(StorageImpl.getLastIdPositionHashMap(), position);
        StorageImpl.setPositionHashMap(positionHashMap);

    }

    @Override
    public boolean isPositionName(String positionName) {
//        return !Storage.positionHashMap.values().stream().filter(position -> position.getPositionName().equals(positionName)).findFirst().isEmpty();
        return !StorageImpl.getPositionHashMap().values().stream().filter(position -> position.getPositionName().equals(positionName)).findFirst().isEmpty();
    }

    @Override
    public boolean isPositionKey(int positionName) {
        return StorageImpl.getPositionHashMap().containsKey(positionName);
    }


    @Override
    public void deleateStudentByName(String positionName) {
        Position position = getPositionByName(positionName);


    }

    @Override
    public HashMap<Integer, Position> getAllPositions() {
//        return Storage.positionHashMap;
        return StorageImpl.getPositionHashMap();
    }

    @Override
    public void changePositionDAO() {

    }

    @Override
    public Position getPositionByName(String positionName) {
//        return Storage.positionHashMap.values().stream().filter(position -> position.getPositionName().equals(positionName)).findFirst().get();
        return StorageImpl.getPositionHashMap().values().stream().filter(position -> position.getPositionName().equals(positionName)).findFirst().get();
    }

    @Override
    public Position getPositionById(String positionId) {
        return StorageImpl.getPositionHashMap().get(positionId);
    }


}
