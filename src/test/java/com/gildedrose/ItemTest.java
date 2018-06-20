package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private Item item;

    @Before
    public void Setup(){
        item = new Item("Aged Brie", 10, 50);
    }

    @Test
    public void ReturnsCorrectString() {
        String expectedString = "Aged Brie, 10, 50";
        assertEquals(expectedString, item.toString());
    }
}
