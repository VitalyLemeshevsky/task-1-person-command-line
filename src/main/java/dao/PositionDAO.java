package dao;

import models.Position;

import java.util.HashMap;

public interface PositionDAO {

    public void addPositionDAO(String positionName);
    public void changePositionDAO();
    public HashMap<Integer, Position> getAllPositions();
    public PositionDAO getPositionByName(String positionName);
    boolean isPositionName(String positionName);

}
