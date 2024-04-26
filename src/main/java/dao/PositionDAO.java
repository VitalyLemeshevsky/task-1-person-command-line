package dao;

import models.Position;

import java.util.HashMap;

public interface PositionDAO {

    public void addPositionDAO(String positionName);
    public void changePositionDAO(int positionId, String positionName);
    public HashMap<Integer, Position> getAllPositions();
    public Position getPositionByName(String positionName);
    public Position getPositionById(Integer positionId);
    public boolean isPositionName(String positionName);
    public boolean isPositionKey(int positionName);
    public void deleatePositionByName(String positionName);



}
