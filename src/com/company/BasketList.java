package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class BasketList implements BasketFunctions {

    Map<String, ItemPOJO> list;

    public BasketList(Map<String, ItemPOJO> list) {
        this.list = list;
    }

    @Override
    public void addItem(String key, ItemPOJO itemPOJO) {
        if(itemPOJO.getQuantity() < 1) {
            System.out.println("Quantity can not be less than 1");
            throw new IllegalStateException();
        } else if (list.containsKey(key)){
            int i = itemPOJO.quantity + list.get(key).quantity;
            if(i<0){
                System.out.println("Removing items may not result in negative amount");
                throw new IllegalStateException();
            }
            else {
                itemPOJO.setQuantity(i);
                list.put(key, itemPOJO);
            }
        } else {
            list.put(key, itemPOJO);
        }
    }

    @Override
    public void deleteItem(String key) {
            if(list.containsKey(key)){
                list.remove(key);
                System.out.println("Deleted item from list: " + key);
            } else {
                throw new NoSuchElementException();
        }
    }

    @Override
    public double getPrice() {
        return list.values()
                .stream().mapToDouble(itemPOJO -> itemPOJO.getQuantity() * itemPOJO.getPrice()).sum();
    }
}
