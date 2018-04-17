package org.echocat.kata.java.part1.menu;

import org.echocat.kata.java.part1.DataContainer;
import org.echocat.kata.java.part1.model.Printing;

import java.util.Comparator;
import java.util.List;

public class SortPrintingsTitleAction extends Action<List<Printing>> {

    public SortPrintingsTitleAction(DataContainer dataContainer) {
        super(dataContainer);
    }

    @Override
    public String getAction() {
        return "spt";
    }

    @Override
    public String getDescription() {
        return "Sort books and magazines by title";
    }

    @Override
    public List<Printing> doAction(String ignored) {
        List<Printing> printings = dataContainer.getPrintings();
        printings.sort(Comparator.comparing(Printing::getTitle));
        return printings;
    }
}
