package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class GildedRoseTest {

    private GildedRose app;

    @Nested
    class AgedBrie{

        private Item[] items;

        @BeforeEach
        void Setup(){
            items = new Item[]{
                    new Item("Aged Brie", 2, 0), //
                    new Item("Aged Brie", 2, 50),
                    new Item("Aged Brie", -1, 20)
            };
            app = new GildedRose(items);
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
        }

    }

    @Nested
    class Sulfuras{

        private Item[] items;

        @BeforeEach
        void Setup(){
            items = new Item[]{
                    new Item("Sulfuras, Hand of Ragnaros", 2, 80),
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80)
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        void QualityNeverChanges(){
            app.updateQuality();
            assertEquals(80, items[0].quality);
            assertEquals(80, items[1].quality);
        }

        @Test
        void SellInNeverChanges(){
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
            assertEquals(0, items[1].sellIn);
        }

    }

    @Nested
    class BackStagePasses{

        private Item[] items;

        @BeforeEach
        void Setup(){

            items = new Item[]{
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        @DisplayName("QualityIncreasesBy1SellInGreaterThan10")
        void QualityChange(){
            assertEquals(21, items[0].quality);
        }

        @Test
        @DisplayName("QualityIncreasesBy2SellInLessThan10GreaterThan5")
        void QualityChange2(){
            assertEquals(22, items[1].quality);
        }

        @Test
        @DisplayName("QualityIncreasesBy3SellInLessThan5GreaterThan0")
        void QualityChange3(){
            assertEquals(23, items[2].quality);
        }

        @Test
        @DisplayName("QualityIs0SellIn0")
        void QualityChange4(){
            assertEquals(0, items[3].quality);
        }

        @Test
        @DisplayName("QualityIs0SellInLessThan0")
        void QualityChange5(){
            assertEquals(0, items[4].quality);
        }

        @Test
        @DisplayName("SellInDecreasesEachDay")
        void SellInChange(){
            assertEquals(14, items[0].sellIn);
        }

        @Test
        @DisplayName("QualityNeverExceeds50")
        void QualityMaximum(){
            assertEquals(50, items[5].quality);
            assertEquals(50, items[6].quality);
        }

    }

    @Nested
    class RegularItems {

        private Item[] items;

        @BeforeEach
        void Setup() {

            items = new Item[]{
                    new Item("+5 Dexterity Vest", 10, 20),
                    new Item("Elixir of the Mongoose", 5, 53),
                    new Item("Elixir of the Mongoose", 0, 20),
                    new Item("Elixir of the Mongoose", 20, 1),
                    new Item("Elixir of the Mongoose", -1, 5)
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        @DisplayName("QualityDecreasesBy1EachDay")
        void QualityDecrease(){
            assertEquals(19, items[0].quality);
        }

        @Test
        @DisplayName("SellInDecreasesBy1EachDay")
        void SellInDecrease(){
            assertEquals(9, items[0].sellIn);
        }

        @Test
        @DisplayName("QualityDecreasesTwiceAsFastAfterSellInPasses")
        void QualityDecrease2(){
            assertEquals(18, items[2].quality);
        }

        @Test
        @DisplayName("QualityIsNeverNegative")
        void QualityMinimum(){
            app.updateQuality();
            assertEquals(0, items[3].quality);
        }

        @Test
        @DisplayName("QualityDecreasesBy2SellInLessThan0")
        void QualityDecrease3(){
            assertEquals(3, items[4].quality);
        }

    }

    @Nested
    class Conjured {

        private Item[] items;

        @BeforeEach
        void Setup() {

            items = new Item[]{
                    new Item("Conjured Mana Cake", 3, 6),
                    new Item("Conjured Mana Cake", 3, 0)
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        @DisplayName("QualityDecreasesTwiceAsFast")
        void QualityDecrease(){
            assertEquals(4, items[0].quality);
        }

        @Test
        @DisplayName("SellinDecreasesBy1EachDay")
        void SellInDecrease(){
            assertEquals(3, items[0].sellIn);
        }

        @Test
        @DisplayName("QualityMinimum")
        void QualityMinimum(){
            assertEquals(0, items[1].quality);
        }

    }

}
