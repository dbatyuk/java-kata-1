package org.echocat.kata.java.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Printing;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class DataContainer {

    private final List<Author> authors;
    private final List<Book> books;
    private final List<Magazine> magazines;

    public List<Printing> getPrintings(){
        List<Printing> books = new ArrayList<>(this.books);
        books.addAll(magazines);
        return books;
    }
}
