package ru.job4j.tracker;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Количество пассажиров: " + amount);
    }

    @Override
    public int refuel(int fuel) {
        int price = fuel * 50;
        return price;
    }
}
