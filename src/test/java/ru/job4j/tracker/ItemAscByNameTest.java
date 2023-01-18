package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {
    @Test
    public void whenAscByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("GHI"),
                new Item("ABC"),
                new Item("JKL"),
                new Item("DEF")
        );
        List<Item> expected = Arrays.asList(
                new Item("ABC"),
                new Item("DEF"),
                new Item("GHI"),
                new Item("JKL")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}