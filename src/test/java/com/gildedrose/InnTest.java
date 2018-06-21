package com.gildedrose;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class InnTest {

    private Inn app;
    private ItemExtended[] items;

    @Nested
    class AgedBrie{

        @BeforeEach
        void Setup(){
            items = new ItemExtended[]{
                    new RegularItem("Aged Brie", 2, 0), //
                    new RegularItem("Aged Brie", 2, 50),
                    new RegularItem("Aged Brie", -1, 20),
                    new RegularItem("Aged Brie", -1, 50)
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

    @Nested
    class SulfurasTest{

        @BeforeEach
        void Setup(){
            items = new ItemExtended[]{
                    new Sulfuras("Sulfuras, Hand of Ragnaros", 2, 80),
                    new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),
                    new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 50)
            };
            app = new Inn(items);
            app.updateQuality();
        }

        @Test
        void QualityNeverChanges(){
            app.updateQuality();
            assertEquals(80, items[0].quality);
            assertEquals(80, items[1].quality);
            assertEquals(50, items[2].quality);
        }

        @Test
        void SellInNeverChanges(){
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
            assertEquals(0, items[1].sellIn);
            assertEquals(-1, items[2].sellIn);
        }

    }

    @Nested
    class BackStagePasses{

        @BeforeEach
        void Setup(){

            items = new ItemExtended[]{
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", -1, 20),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                    new BackStagePass("Backstage passes to a TAFKAL80ETC concert", -1, 50),
            };
            app = new Inn(items);
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
            assertEquals(0, items[8].quality);
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
            assertEquals(50, items[7].quality);
        }

    }

    @Nested
    class RegularItems {

        @BeforeEach
        void Setup() {

            items = new ItemExtended[]{
                    new RegularItem("+5 Dexterity Vest", 10, 20),
                    new RegularItem("Elixir of the Mongoose", 5, 53),
                    new RegularItem("Elixir of the Mongoose", 0, 20),
                    new RegularItem("Elixir of the Mongoose", 20, 1),
                    new RegularItem("Elixir of the Mongoose", -1, 5),
                    new RegularItem("Elixir of the Mongoose", -1, 0),
                    new RegularItem("Elixir of the Mongoose", -1, 50)
            };
            app = new Inn(items);
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
            assertEquals(48, items[6].quality);
        }

        @Test
        @DisplayName("QualityStays0SellInLessThan0")
        void QualityDecrease4(){
            assertEquals(0, items[5].quality);
        }

    }

    @Nested
    class Conjured {


        @BeforeEach
        void Setup() {

            items = new ItemExtended[]{
                    new RegularItem("Conjured Mana Cake", 3, 6),
                    new RegularItem("Conjured Mana Cake", 3, 0),
                    new RegularItem("Conjured Mana Cake", -1, 6),
                    new RegularItem("Conjured Mana Cake", -1, 0),
            };
            app = new Inn(items);
            app.updateQuality();
        }

        @Test
        @DisplayName("QualityDecreasesTwiceAsFast")
        void QualityDecrease(){
            assertEquals(4, items[0].quality);
        }

        @Test
        @DisplayName("QualityDecreasesBy4SellinLessThan0")
        void QualityDecrease2(){
            assertEquals(2, items[2].quality);
        }

        @Test
        @DisplayName("SellinDecreasesBy1EachDay")
        void SellInDecrease(){
            assertEquals(2, items[0].sellIn);
        }

        @Test
        @DisplayName("QualityMinimum")
        void QualityMinimum(){
            assertEquals(0, items[1].quality);
        }

        @Test
        @DisplayName("QualityMinimumSellInLessThan0")
        void QualityMinimum2(){
            assertEquals(0, items[3].quality);
        }

    }





}
