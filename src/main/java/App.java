import dao.PositionDAO;
import dao.impl.PositionDAOImpl;
import utilitys.CreatingMap;
import utilitys.DefaultData;
import utilitys.ConsoleMenu;

import java.util.Scanner;

public class App {
    private final static Scanner console = new Scanner(System.in);
    //^([1-9]|1[0-2])$
    private final static String regex = "^([1-5])$";
    private static PositionDAO positionDAO = new PositionDAOImpl();

    public static void main(String[] args) {
        CreatingMap creatingMap = new CreatingMap();
        DefaultData defaultData = new DefaultData(positionDAO);
        defaultData.init();
        String choiceMade = "";
        Boolean choiseAction = true;


        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.print();

        while (choiceMade.equals("")) {
            choiceMade = console.nextLine();
            if (!(choiceMade.matches(regex))) {
                System.out.println("Внимание!!!! Такого варианта выбора нет - " + choiceMade);
                System.out.println("Программа будет запущена повторно.");
                System.out.println("----------------------------------------------------------------------------------");
                consoleMenu.print();
                choiceMade = "";
            }
        }

        creatingMap.execute(Integer.parseInt(choiceMade));
        choiceMade = "";

        while (choiseAction) {
            System.out.println("Хотите продолжить работой с программой? (если Да-то введите y, если Нет- " +
                    "то введите любой другое значение");
            if (console.nextLine().equals("y")) {
                consoleMenu.print();
                while (choiceMade.equals("")) {
                    choiceMade = console.nextLine();
                    if (!(choiceMade.matches(regex))) {
                        System.out.println("Внимание!!!! Такого варианта выбора нет - " + choiceMade);
                        System.out.println("Программа будет запущена повторно.");
                        System.out.println("----------------------------------------------------------------------------------");
                        consoleMenu.print();
                        choiceMade = "";
                    }
                }
                creatingMap.execute(Integer.parseInt(choiceMade));
                choiceMade = "";
            } else {
                choiseAction = false;
            }
        }
    }
}