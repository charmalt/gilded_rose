package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class GildedRoseTest {

    private GildedRose app;

    @Nested
    class CheckTexttestFixture{

        @BeforeEach
        public void Setup(){
            Item[] items = new Item[] {
                    new Item("+5 Dexterity Vest", 10, 20), //
                    new Item("Aged Brie", 2, 0), //
                    new Item("Elixir of the Mongoose", 5, 7), //
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    // this conjured item does not work properly yet
                    new Item("Conjured Mana Cake", 3, 6) };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        public void DexterityVestUpdateBehaviour() {
            assertEquals("+5 Dexterity Vest", app.items[0].name);
            assertEquals(9, app.items[0].sellIn);
            assertEquals(19, app.items[0].quality);
        }

        @Test
        public void agedBrieUpdateBehaviour(){
            assertEquals("Aged Brie", app.items[1].name);
            assertEquals(1, app.items[1].sellIn);
            assertEquals(1, app.items[1].quality);
        }

        @Test
        public void ElixirUpdateBehaviour(){
            assertEquals("Elixir of the Mongoose", app.items[2].name);
            assertEquals(4, app.items[2].sellIn);
            assertEquals(6, app.items[2].quality);
        }

        @Test
        public void SulfurasUpdateBehaviour(){
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[3].name);
            assertEquals(0, app.items[3].sellIn);
            assertEquals(80, app.items[3].quality);
        }

        @Test
        public void SulfurasUpdateBehaviour2ndCheck(){
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[4].name);
            assertEquals(-1, app.items[4].sellIn);
            assertEquals(80, app.items[4].quality);
        }

        @Test
        public void BackStagePassUpdateBehaviour(){
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[5].name);
            assertEquals(14, app.items[5].sellIn);
            assertEquals(21, app.items[5].quality);
        }

        @Test
        public void BackStagePassUpdateBehaviour2ndCheck(){
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[6].name);
            assertEquals(9, app.items[6].sellIn);
            assertEquals(50, app.items[6].quality);
        }

        @Test
        public void BackStagePassUpdateBehaviour3rdCheck(){
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[7].name);
            assertEquals(4, app.items[7].sellIn);
            assertEquals(50, app.items[7].quality);
        }

        @Test
        public void ConjuredMana(){
            assertEquals("Conjured Mana Cake", app.items[8].name);
            assertEquals(2, app.items[8].sellIn);
            assertEquals(4, app.items[8].quality);
        }

    }

    @Nested
    class AgedBrie{

        private Item[] items;

        @BeforeEach
        public void Setup(){
            items = new Item[]{
                    new Item("Aged Brie", 2, 0), //
                    new Item("Aged Brie", 2, 50)
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        public void QualityIncreasesBy1EachDay(){
            app.updateQuality();
            assertEquals(2, items[0].quality);
        }

        @Test
        public void MaximumQualityIs50(){
            app.updateQuality();
            assertEquals(50, items[1].quality);
        }

    }

    @Nested
    class Sulfuras{

        private Item[] items;

        @BeforeEach
        public void Setup(){
            items = new Item[]{
                    new Item("Sulfuras, Hand of Ragnaros", 2, 80)
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        public void QualityNeverChanges(){
            app.updateQuality();
            assertEquals(80, items[0].quality);
        }

        @Test
        public void SellInNeverChanges(){
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
        }

    }

    @Nested
    class BackStagePasses{

        private Item[] items;

        @BeforeEach
        public void Setup(){

            items = new Item[]{
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20),
            };
            app = new GildedRose(items);
            app.updateQuality();
        }

        @Test
        @DisplayName("QualityIncreasesBy1SellInGreaterThan10")
        public void QualityChange(){
            assertEquals(21, items[0].quality);
        }

        @Test
        @DisplayName("QualityIncreasesBy2SellInLessThan10GreaterThan5")
        public void QualityChange2(){
            assertEquals(22, items[1].quality);
        }

        @Test
        @DisplayName("QualityIncreasesBy3SellInLessThan5GreaterThan0")
        public void QualityChange3(){
            assertEquals(23, items[2].quality);
        }

        @Test
        @DisplayName("QualityIs0SellIn0")
        public void QualityChange4(){
            assertEquals(0, items[3].quality);
        }

        @Test
        @DisplayName("QualityIs0SellInLessThan0")
        public void QualityChange5(){
            assertEquals(0, items[4].quality);
        }

        @Test
        @DisplayName("SellInDecreasesEachDay")
        public void SellInChange(){
            assertEquals(14, items[0].sellIn);
        }

    }

}
