package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {
    @Test
    public void whenDescByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("GHI"),
                new Item("ABC"),
                new Item("JKL"),
                new Item("DEF")
        );
        List<Item> expected = Arrays.asList(
                new Item("JKL"),
                new Item("GHI"),
                new Item("DEF"),
                new Item("ABC")
                );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}