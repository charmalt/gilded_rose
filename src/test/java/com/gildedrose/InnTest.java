package com.gildedrose;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class InnTest {

    private Inn app;
    private Item[] items;

    @Nested
    class AgedBrie{

        private Item[] items;

        @BeforeEach
        void Setup(){
            items = new Item[]{
                    new Item("Aged Brie", 2, 0), //
                    new Item("Aged Brie", 2, 50),
                    new Item("Aged Brie", -1, 20),
                    new Item("Aged Brie", -1, 50)
            };
            app = new Inn(items);
            app.updateQuality();
        }

        @Test
        void QualityIncreasesBy1EachDay(){
            app.updateQuality();
            assertEquals(2, items[0].quality);
        }

        @Test
        void QualityIncreasesBy2SellInLessThan0(){
            assertEquals(22, items[2].quality);
        }

        @Test
        void MaximumQualityIs50(){
            app.updateQuality();
            assertEquals(50, items[1].quality);
            assertEquals(50, items[3].quality);
        }

    }




}
