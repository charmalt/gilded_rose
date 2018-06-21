package com.gildedrose;

class AgedBrie extends Item implements UpdateInterface {


    AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    void updateItemQuality(){
        changeValue(item, getDelta(item, 1, 2));
    }

    void updateSellIn(){
        sellIn --;
    }

}
