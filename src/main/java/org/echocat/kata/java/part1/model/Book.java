package org.echocat.kata.java.part1.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Book extends Printing {

    private final String description;

    public Book(String title, String isbn, List<String> authors, String description) {
        super(title, isbn, authors);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
