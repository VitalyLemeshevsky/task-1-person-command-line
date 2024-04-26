package menuCommand;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.PositionDAO;

import java.util.Scanner;

public interface MenuCommand {
    public void execute() throws JsonProcessingException;
}
