package com.company;

import java.util.HashMap;
import java.util.Map;

public class BasketList implements BasketFunctions{

    Map<String, BasketModel> list = new HashMap<>();

    @Override
    public void addItem(BasketModel basketModel) {
        if(basketModel.getQuantity() < 1){
            System.out.println("Quantity can not be less than 1");
        } else if (list.containsKey(basketModel.getName())){
            int i = list.get(basketModel.getName()).quantity;
            list.get(basketModel.getName())
                    .setQuantity(basketModel.getQuantity()+i);
        } else {
            list.put(basketModel.getName(), basketModel);
        }
    }

    @Override
    public void deleteItem(String key) {
        if(list.containsKey(key)){
            list.remove(key);
            System.out.println("Deleted item from list: " + key);
        }else {
            System.out.println("Item with given keyword does not exist");
        }
    }

    @Override
    public double getPrice(BasketList basketList) {
        return basketList.list.values()
                .stream().mapToDouble(basketModel -> basketModel.getQuantity() * basketModel.getPrice()).sum();
    }
}
