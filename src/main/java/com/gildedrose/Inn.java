package com.gildedrose;

public class Inn {

    Item[] items;
    static final int MAXIMUM_QUALITY = 50;

    Inn(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (Item item : items) {
            updateSellin(item);
            updateItemQuality(item);
        }

    }

    void updateSellin(Item item){
        item.sellIn = item.name.equals("Sulfuras, Hand of Ragnaros") ? item.sellIn : item.sellIn - 1 ;
    }

    void updateItemQuality(Item item){

        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item, 1, 2 );
                break;
            default:

                break;
        }

    }

    void increaseQuality(Item item, int increaseAboveZeroSellIn, int increaseBelowZeroSellIn){
            int delta = item.sellIn >= 0 ? increaseAboveZeroSellIn : increaseBelowZeroSellIn;

            if (item.quality < MAXIMUM_QUALITY){
                item.quality = (MAXIMUM_QUALITY - item.quality) >= delta ? item.quality + delta : MAXIMUM_QUALITY;
            }

    }


}
