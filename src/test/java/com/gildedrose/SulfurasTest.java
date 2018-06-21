package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    @Nested
    class SulfurasTesting {

        Sulfuras item, item2, brie, conjured;

        @BeforeEach
        void Setup() {

            item = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
            item2 = new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80);

        }

        @Test
        @DisplayName("Get Correct Delta")
        void DeltaCheck(){
            assertEquals(0, item.getDelta());
        }

        @Test
        @DisplayName("Update Item Quality")
        void QualityChange(){
            item.updateItemQuality();
            assertEquals(80, item.quality);
            item2.updateItemQuality();
            assertEquals(80, item2.quality);
        }

        @Test
        @DisplayName("Update SellIn")
        void SellInChange(){
            item.updateSellIn();
            assertEquals(0, item.sellIn);
        }

    }

}
