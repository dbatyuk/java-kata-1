package org.echocat.kata.java.part1.menu;

import org.echocat.kata.java.part1.DataContainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleOutputMenu implements Menu {

    private final Map<String, Action> ACTIONS = new HashMap<>();

    public ConsoleOutputMenu(DataContainer dataContainer) {
        FindBookIsbnAction findBookIsbnAction = new FindBookIsbnAction(dataContainer);
        ACTIONS.put(findBookIsbnAction.getAction(), findBookIsbnAction);

        FindPrintingAuthorEmailAction findPrintingAuthorEmailAction = new FindPrintingAuthorEmailAction(dataContainer);
        ACTIONS.put(findPrintingAuthorEmailAction.getAction(), findPrintingAuthorEmailAction);

        SortPrintingsTitleAction sortPrintingsTitleAction = new SortPrintingsTitleAction(dataContainer);
        ACTIONS.put(sortPrintingsTitleAction.getAction(), sortPrintingsTitleAction);

        FindAllPrintingsAction findAllPrintingsAction = new FindAllPrintingsAction(dataContainer);
        ACTIONS.put(findAllPrintingsAction.getAction(), findAllPrintingsAction);
    }

    @Override
    public Void doAction(String actionName, String input) {
        Action action = ACTIONS.get(actionName);

        if (action == null) {
            System.out.println("\n" + actionName + " action not found");
            return null;
        }

        Object result = action.doAction(input);
        if (result != null) {
            if (result instanceof List) {
                ((List)result).forEach(System.out::println);
            } else {
                System.out.println("\n" + result.toString());
            }
            return null;
        }

        System.out.println("action no result");
        return null;
    }

    @Override
    public Void showMenu() {
        System.out.println("\nMenu:");
        ACTIONS.values().stream().forEach(a -> System.out.println(a.getAction() + " - " + a.getDescription()));

        return null;
    }
}
