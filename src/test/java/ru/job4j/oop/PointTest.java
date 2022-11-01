package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {
    @Test
    public void when2() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double rsl = a.distance(b);
        double expected = 4;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        double rsl = a.distance3d(b);
        double expected = 4;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}