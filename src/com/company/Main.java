package com.company;

import java.util.HashMap;

public class Main {
    public static void main(final String[] args)  {
        HashMap<String,ItemPOJO> map = new HashMap<>();
        BasketList basketList = new BasketList(map);
        basketList.addItem("abc", new ItemPOJO("abc", 5, 3));
        basketList.addItem("def", new ItemPOJO("abc", 5, 5));
        basketList.addItem("ghi", new ItemPOJO("eee", 5, 3));
        basketList.deleteItem("abcc");
        basketList.list.entrySet().forEach(i -> System.out.println(
                    i.getKey() + ": " +
                        i.getValue().getName() +
                        " " + i.getValue().getPrice() +
                                " " + i.getValue().getQuantity()));
        System.out.println(basketList.getPrice());
        System.out.println(basketList.list.keySet());
        System.out.println(basketList.list);

    }
}
