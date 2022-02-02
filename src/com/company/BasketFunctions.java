package com.company;

import java.util.Map;

public interface BasketFunctions {

    void addItem(String key, ItemPOJO itemPOJO);
    void deleteItem(String key);
    double getPrice();
}
