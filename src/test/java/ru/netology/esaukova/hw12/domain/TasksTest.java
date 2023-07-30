package ru.netology.esaukova.hw12.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void matchesTrueInTitleTest() {
        SimpleTask simpleTask = new SimpleTask(1, "Сделать ДЗ");
        String query = "Сделать ДЗ";
        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesTrueInSubtaskTest() {
        String[] subtasks = {"Завтак", "Обед", "Ужин"};
        Epic epic = new Epic(5, subtasks);
        String query = "Ужин";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesTrueInTopicTest() {
        Meeting meeting = new Meeting(
                10,
                "Изучение JAVA",
                "Нетология",
                "2023-07-30");

        String query = "JAVA";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesTrueInProjectTest() {
        Meeting meeting = new Meeting(
                10,
                "Изучение JAVA",
                "Нетология",
                "2023-07-30");
        String query = "Нетология";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesFalseNotInTitleTest() {
        SimpleTask simpleTask = new SimpleTask(1, "Сделать ДЗ");
        String query = "Сдать ДЗ";
        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesFalseNotInSubtaskTest() {
        String[] subtasks = {"Завтак", "Обед", "Ужин"};
        Epic epic = new Epic(5, subtasks);
        String query = "Полдник";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void matchesFalseNotInMeeting() {
        Meeting meeting = new Meeting(
                10,
                "Изучение JAVA",
                "Нетология",
                "2023-07-30");

        String query = "Python";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void hashCodeTest() {
        String[] subtasks = {"Завтак", "Обед", "Ужин"};
        Epic epic = new Epic(6, subtasks);
        SimpleTask simpleTask = new SimpleTask(6, "Сделать ДЗ");

        Assertions.assertEquals(epic.hashCode(), simpleTask.hashCode());
    }

}
