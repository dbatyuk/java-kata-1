package org.echocat.kata.java.part1.menu;

import org.echocat.kata.java.part1.DataContainer;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Printing;

import java.util.List;
import java.util.stream.Collectors;

public class FindPrintingAuthorEmailAction extends Action<List<Printing>> {

    public FindPrintingAuthorEmailAction(DataContainer dataContainer) {
        super(dataContainer);
    }

    @Override
    public String getAction() {
        return "fpae";
    }

    @Override
    public String getDescription() {
        return "Find books and magazines by their author's email";
    }

    @Override
    public List<Printing> doAction(String author) {
        return dataContainer.getPrintings().stream()
                .filter(p -> p.getAuthors().contains(author))
                .collect(Collectors.toList());
    }
}
