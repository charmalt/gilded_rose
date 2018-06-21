package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    private Item[] items;

    @BeforeEach
    void Setup(){
        items = new Item[]{
                new AgedBrie(2, 0), //
                new AgedBrie(2, 50),
                new AgedBrie(-1, 20),
                new AgedBrie(-1, 50)
        };

        for (int i=0; i < items.length ; i++){
            items[i].updateQuality();
        }


    }

    @Test
    void QualityIncreasesBy1EachDay(){

        assertEquals(2, items[0].quality);
    }

    @Test
    void QualityIncreasesBy2SellInLessThan0(){

        assertEquals(22, items[2].quality);
    }

    @Test
    void MaximumQualityIs50(){

        assertEquals(50, items[1].quality);
        assertEquals(50, items[3].quality);
    }

}
