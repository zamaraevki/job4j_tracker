package ru.job4j.oop;

public class PolyVehicle {
    public static void main(String[] args) {
        Vehicle ap1 = new Airplane();
        Vehicle ap2 = new Airplane();
        Vehicle tr1 = new Train();
        Vehicle tr2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = new Vehicle[]{ap1, ap2, tr1, tr2, bus1, bus2};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
