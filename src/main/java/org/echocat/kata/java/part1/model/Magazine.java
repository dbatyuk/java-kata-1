package org.echocat.kata.java.part1.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Magazine extends Printing {

    private final LocalDate publishedAt;

    public Magazine(String title, String isbn, List<String> authors, LocalDate publishedAt) {
        super(title, isbn, authors);
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "publishedAt=" + publishedAt +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
