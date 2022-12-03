package ru.job4j.tracker;

public interface Transport {
    void drive();

    void passengers(int amount);

    int refuel(int fuel);
}
