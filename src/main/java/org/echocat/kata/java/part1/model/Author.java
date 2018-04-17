package org.echocat.kata.java.part1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Author {

    private final String email;
    private final String firstName;
    private final String lastName;
}
