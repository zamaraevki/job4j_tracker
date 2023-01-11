package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = count; 1 < i; i--) {
            queue.poll();
        }
        return queue.element().name();
    }

    public String getLastUpsetCustomer() {
        for (int i = count; 0 < i; i--) {
            queue.poll();
        }
        return queue.element().name();
    }
}
