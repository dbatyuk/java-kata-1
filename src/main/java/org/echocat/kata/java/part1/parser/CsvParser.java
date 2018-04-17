package org.echocat.kata.java.part1.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.echocat.kata.java.part1.parser.CSVHeaders.*;

public class CsvParser {

    private static final String BASE_PATH = "org/echocat/kata/java/part1/data/";

    public List<Author> parseAllAuthors() {
        return parse("authors.csv", AUTHOR,
                r -> new Author(r.get(EMAIL), r.get(FIRSTNAME), r.get(LASTNAME)));
    }

    public List<Book> parseAllBooks() {
        return parse("books.csv", BOOK,
                r -> new Book(r.get(TITLE), r.get(ISBN), parseList(r.get(AUTHORS)), r.get(DESCRIPTION)));
    }

    public List<Magazine> parseAllMagazines() {
        return parse("magazines.csv", MAGAZINE,
                r -> new Magazine(r.get(TITLE), r.get(ISBN), parseList(r.get(AUTHORS)), parseLocalDate(r.get(PUBLISHED_AT))));
    }

    private <T> List<T> parse(String fileName, String[] headers, Function<CSVRecord, T> recordToEntityMapFunc) {
        try {
            InputStream authorsInputStream = getClass().getClassLoader().getResourceAsStream(BASE_PATH + fileName);
            Reader reader = new InputStreamReader(authorsInputStream);

            CSVParser records = CSVFormat.newFormat(';').withSkipHeaderRecord().withHeader(headers).parse(reader);

            return records.getRecords().stream()
                    .map(recordToEntityMapFunc)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<String> parseList(String field) {
        return Arrays.stream(field.split(",")).collect(Collectors.toList());
    }

    private static LocalDate parseLocalDate(String field) {
        return LocalDate.parse(field, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
