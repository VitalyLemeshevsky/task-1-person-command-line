package utilitys;

import dao.PositionDAO;

public class DefaultData {
    private PositionDAO positionDAO;
    public DefaultData(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }
    public void init() {
        positionDAO.addPositionDAO("Босс");
        positionDAO.addPositionDAO("Маркетолог");
        positionDAO.addPositionDAO("Исполнитель");

    }
}
