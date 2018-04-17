package org.echocat.kata.java.part1.parser;

public class CSVHeaders {

    public static final String EMAIL = "email";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String TITLE = "title";
    public static final String ISBN = "isbn";
    public static final String AUTHORS = "authors";
    public static final String DESCRIPTION = "description";
    public static final String PUBLISHED_AT = "publishedAt";

    public static final String[] AUTHOR = new String[]{EMAIL, FIRSTNAME, LASTNAME};
    public static final String[] BOOK = new String[]{TITLE, ISBN, AUTHORS, DESCRIPTION};
    public static final String[] MAGAZINE = new String[]{TITLE,ISBN,AUTHORS, PUBLISHED_AT};
}
