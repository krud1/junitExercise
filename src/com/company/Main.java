package com.company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(final String[] args) {

        BasketList basketList = new BasketList();
        basketList.addItem(new BasketModel("abc", 5, 5));
        basketList.addItem(new BasketModel("abc", 5, 5));
        basketList.addItem(new BasketModel("eee", 5, 3));

        basketList.list.entrySet().forEach(i -> System.out.println(
                    i.getKey() + ": " +
                        i.getValue().getName() +
                        " " + i.getValue().getPrice() +
                                " " + i.getValue().getQuantity()));
        System.out.println(basketList.getPrice(basketList));

    }
}
