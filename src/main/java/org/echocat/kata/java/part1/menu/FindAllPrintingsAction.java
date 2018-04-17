package org.echocat.kata.java.part1.menu;

import org.echocat.kata.java.part1.DataContainer;
import org.echocat.kata.java.part1.model.Printing;

import java.util.ArrayList;
import java.util.List;

public class FindAllPrintingsAction extends Action<List<Printing>> {

    public FindAllPrintingsAction(DataContainer dataContainer) {
        super(dataContainer);
    }

    @Override
    public String getAction() {
        return "fap";
    }

    @Override
    public String getDescription() {
        return "Find all books and magazines";
    }

    @Override
    public List<Printing> doAction(String type) {
        if (type.equals("book")) {
            return new ArrayList<>(dataContainer.getBooks());
        } else if (type.equals("magazine")) {
            return new ArrayList<>(dataContainer.getMagazines());
        }

        return null;
    }
}
