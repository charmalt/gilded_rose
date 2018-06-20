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
    public void HasNameAttribute(){
        assertEquals("Aged Brie", item.name);
    }

    @Test
    public void HasSellinAttribute(){
        assertEquals(10, item.sellIn);
    }

    @Test
    public void HasQualityAttribute(){
        assertEquals(50, item.quality);
    }

    @Test
    public void ReturnsCorrectString() {
        String expectedString = "Aged Brie, 10, 50";
        assertEquals(expectedString, item.toString());
    }
}
