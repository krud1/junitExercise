package com.company;

import org.junit.Before;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class BasketListTest {

    BasketList basket;

    /**
    * AddItem method from BasketList.class
    */

    @BeforeEach
    public void setUp(){
        basket = new BasketList(new HashMap<>());
        basket.list.clear();
    }

    @Test
    @DisplayName("Adds item to basketlist correctly")
    public void shouldAddItemToBasketList(){
        basket.addItem("test", new ItemPOJO("test1", 3,2));
        Assertions.assertEquals(basket.list.size(), 1);
        Assertions.assertEquals(2, basket.list.get("test").getQuantity());
        Assertions.assertEquals(3, basket.list.get("test").getPrice());
        Assertions.assertEquals("test1", basket.list.get("test").getName());
    }

    @Test
    @DisplayName("Add item with quantity 0 throws IllegalStateException")
    public void shouldThrow_ISE_whenQuantityIs_0(){
        Assertions.assertThrows(IllegalStateException.class,
                () -> basket.addItem("test", new ItemPOJO("test1", 3,0)));
    }

    @Test
    @DisplayName("Add item existing in list increases its quantity instead of duplicate")
    public void shouldIncreaseQuantityOfItemWhenItemAlreadyExistsInBasketList(){
        basket.addItem("test", new ItemPOJO("test1", 3,2));
        basket.addItem("test", new ItemPOJO("test1", 3,2));
        Assertions.assertEquals(basket.list.size(),1);
        Assertions.assertEquals(basket.list.get("test").getQuantity(),4);
    }

    @Test
    @DisplayName("Add item existing in list resulting in quantity below 0 throws IllegalStateException")
    public void shouldThrow_ISE_whenQuantityBelow_0(){
        basket.addItem("test", new ItemPOJO("test1", 3,2));
        Assertions.assertThrows(IllegalStateException.class,
                () -> basket.addItem("test", new ItemPOJO("test1", 3,-5)));
    }

    /**
     *  DeleteItem from BasketList.class
     */

    @Test
    @DisplayName("Delete item throws NoSuchElementException when key doesn't exist")
    public void shouldThrow_NSEE_whenKeyWordNotExists(){
        Assertions.assertThrows(NoSuchElementException.class, () -> basket.deleteItem("33"));
    }

    @Test
    @DisplayName("Delete item works as intended ( ͡° ͜ʖ ͡°)")
    public void shouldSuccessfullyDeleteItemFromList(){
        basket.addItem("test", new ItemPOJO("test1", 3,2));
        basket.deleteItem("test");
        Assertions.assertEquals(basket.list.size(), 0);
    }

    /**
     * GetPrice method from BasketList.class
     */

    @Test
    @DisplayName("Get price returns correct value")
    public void shouldReturnCorrectPriceOfProductsFromList(){
        basket.addItem("test", new ItemPOJO("test", 35,2));
        basket.addItem("test2", new ItemPOJO("test2", 13,42));
        basket.addItem("test3", new ItemPOJO("test3", 5,2));
        Assertions.assertEquals(basket.getPrice(), 626);
        basket.deleteItem("test");
        Assertions.assertEquals(basket.getPrice(), 556);
    }




}
