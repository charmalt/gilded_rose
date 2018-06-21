package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class RegularItemTest {

    @Nested
    class RegularItems {

        RegularItem item, item2, brie, conjured;

        @BeforeEach
        void Setup() {

            item = new RegularItem("+5 Dexterity Vest", 10, 20);
            item2 = new RegularItem("Elixir of the Mongoose", -5, 53);
            brie = new RegularItem("Aged Brie", 10, 20);
            conjured = new RegularItem("Conjured Mana Cake", -5, 49);

        }

        @Test
        @DisplayName("Get Correct Delta")
        void DeltaCheck(){
            assertEquals(-1, item.getDelta());
            assertEquals(-2, item2.getDelta());
            assertEquals(1, brie.getDelta());
            assertEquals(-4, conjured.getDelta());
        }

        @Test
        @DisplayName("Update Item Quality")
        void QualityChange(){
            item.updateItemQuality();
            assertEquals(19, item.quality);
        }

        @Test
        @DisplayName("Update SellIn")
        void SellInChange(){
            item.updateSellIn();
            assertEquals(9, item.sellIn);
        }

    }

}
