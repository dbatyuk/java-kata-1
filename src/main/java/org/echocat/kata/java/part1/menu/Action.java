package org.echocat.kata.java.part1.menu;

import lombok.AllArgsConstructor;
import org.echocat.kata.java.part1.DataContainer;

@AllArgsConstructor
public abstract class Action<T> {

    protected final DataContainer dataContainer;

    public abstract String getAction();

    public abstract String getDescription();

    public abstract T doAction(String input);
}
