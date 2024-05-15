package utilitys;

import dao.PersonDAO;
import dao.PositionDAO;

import java.util.Date;

public class DefaultData {
    private PositionDAO positionDAO;
    private PersonDAO personDAO;

    public DefaultData(PositionDAO positionDAO, PersonDAO personDAO) {
        this.positionDAO = positionDAO;
        this.personDAO = personDAO;
    }

    public void init() {
        positionDAO.addPositionDAO("Босс");
        positionDAO.addPositionDAO("Маркетолог");
        positionDAO.addPositionDAO("Исполнитель");

        Date date = new Date();
        personDAO.addPerson("Иванов", "Иван", "Иванович", positionDAO.getPositionById(1), true, date, date);
        date = new Date();
        personDAO.addPerson("Петров", "Петр", "Петрович", positionDAO.getPositionById(2), true, date, date);
        date = new Date();
        personDAO.addPerson("Александров", "Александр", "Александрович", positionDAO.getPositionById(3), true, date, date);

    }
}
