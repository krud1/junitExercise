package com.company;

public interface BasketFunctions {

    void addItem(BasketModel basketModel);
    void deleteItem(String key);
    double getPrice(BasketList basketList);
}
