package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.menu.ConsoleOutputMenu;
import org.echocat.kata.java.part1.menu.Menu;
import org.echocat.kata.java.part1.parser.CsvParser;

import java.util.Scanner;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();

        DataContainer dataContainer = mainApp.initData();
        Menu menu = mainApp.initMenu(dataContainer);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();

            if (next.equals("m")) {
                menu.showMenu();
            } else if (next.equals("q")) {
                System.exit(0);
            } else if (next.contains(" ")) {
                String[] split = next.split(" ");
                menu.doAction(split[0], split[1]);
            } else {
                menu.doAction(next, null);
            }
        }
    }

    private DataContainer initData() {
        CsvParser csvParser = new CsvParser();
        return new DataContainer(csvParser.parseAllAuthors(), csvParser.parseAllBooks(), csvParser.parseAllMagazines());
    }

    private Menu initMenu(DataContainer dataContainer) {
        ConsoleOutputMenu consoleOutputMenu = new ConsoleOutputMenu(dataContainer);
        consoleOutputMenu.showMenu();
        return consoleOutputMenu;
    }

}
