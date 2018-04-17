package org.echocat.kata.java.part1.menu;

public interface Menu {


    <T> T doAction(String actionName, String input);

    <T> T showMenu();
}
