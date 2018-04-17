package org.echocat.kata.java.part1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Printing {

    protected final String title;
    protected final String isbn;
    protected final List<String> authors;
}
