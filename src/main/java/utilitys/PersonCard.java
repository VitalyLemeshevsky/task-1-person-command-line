package utilitys;

import java.util.Scanner;

public class PersonCard {
    private Scanner console;
    public PersonCard(Scanner console) {
        this.console = console;
    }
   public String enterTextValueOfField(String title) {
        String fieldValue = "";

        while (fieldValue == "") {
            System.out.println(title);
            fieldValue = console.nextLine();
        }
        return fieldValue;
    }
}
