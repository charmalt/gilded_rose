package com.gildedrose;

public class Inn {

    Item[] items;
    static final int MAXIMUM_QUALITY = 50;
    static final int MINIMUM_QUALITY = 0;

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
        int delta;
        switch (item.name) {
            case "Aged Brie":
                delta = getDelta(item, 1, 2);
                increaseValue(item, delta);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case"Backstage passes to a TAFKAL80ETC concert":
                delta = getBackStageDelta(item);
                increaseValue(item, delta);
            default:

                break;
        }

    }

    int getDelta(Item item, int AboveZeroSellIn, int BelowZeroSellIn){
        return item.sellIn >= 0 ? AboveZeroSellIn : BelowZeroSellIn;
    }

    int getBackStageDelta(Item item){

        if (item.sellIn <= 0 ){
            return -item.quality;
        }

        else if (item.quality < MAXIMUM_QUALITY) {
            if (item.sellIn > 10) {
               return 1;
            } else if (item.sellIn > 5) {
               return 2;
            } else {
               return 3;
            }
        }
        else {
           return 0;
        }

    }

    void increaseValue(Item item, int delta){

        if (delta == -item.quality){
            item.quality = 0;
        }
        else if (item.quality < MAXIMUM_QUALITY){
            item.quality = (MAXIMUM_QUALITY - item.quality) >= delta ? item.quality + delta : MAXIMUM_QUALITY;
        }
    }

}
