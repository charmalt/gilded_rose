package com.gildedrose;

public abstract class UpdateQuality {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    private void changeValue(Item item, int delta){

        if (delta < 0){
            item.quality = (item.quality < -delta)||(-delta == item.quality) ? MINIMUM_QUALITY : item.quality + delta ;
        }
        else {
            item.quality = (MAXIMUM_QUALITY - item.quality) >= delta ? item.quality + delta : MAXIMUM_QUALITY;
        }
    }

    private int getDelta(Item item, int AboveZeroSellIn, int BelowZeroSellIn){
        return item.sellIn >= 0 ? AboveZeroSellIn : BelowZeroSellIn;
    }

}
