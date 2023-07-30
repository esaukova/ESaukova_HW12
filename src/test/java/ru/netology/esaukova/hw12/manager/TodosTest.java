package ru.netology.esaukova.hw12.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.esaukova.hw12.domain.SimpleTask;
import ru.netology.esaukova.hw12.domain.Epic;
import ru.netology.esaukova.hw12.domain.Meeting;
import ru.netology.esaukova.hw12.domain.Task;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTasksIfQueryEmpty() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTasksIfQueryMatchesForAll() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям в 3");

        String[] subtasks = {"Молоко", "Яйца", "3 Хлеба"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3 й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("3");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetThatArrayWhereQueryMatches() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmptyArrayIfQueryNoMatches() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Сделать ДЗ");
        Assertions.assertArrayEquals(expected, actual);
    }

}
