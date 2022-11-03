package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index == products.length - 1) {
            products[index] = null;
        } else {
            for (int i = index; i < products.length - 1; i++) {
                Product temp = products[i + 1];
                products[i] = temp;
                products[i + 1] = null;
            }
        }
        return products;
    }
}
