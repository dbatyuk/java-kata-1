package org.echocat.kata.java.part1.menu;

import org.echocat.kata.java.part1.DataContainer;
import org.echocat.kata.java.part1.model.Book;

public class FindBookIsbnAction extends Action<Book> {

    public FindBookIsbnAction(DataContainer dataContainer) {
        super(dataContainer);
    }

    @Override
    public String getAction() {
        return "fbi";
    }

    @Override
    public String getDescription() {
        return "Find Book by ISBN";
    }

    @Override
    public Book doAction(String isbn) {
        return dataContainer.getBooks().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst().orElse(null);
    }

}
