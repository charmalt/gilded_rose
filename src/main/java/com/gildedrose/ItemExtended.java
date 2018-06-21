package com.gildedrose;

abstract class ItemExtended extends Item implements ItemInterface {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    ItemExtended(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateSellIn(){
        sellIn --;
    }

    public void updateItemQuality(){

        int delta = getDelta();

        if (delta < 0){
            quality = (quality < -delta)||(-delta == quality) ? MINIMUM_QUALITY : quality + delta ;
        }
        else {
            quality = (MAXIMUM_QUALITY - quality) >= delta ? quality + delta : MAXIMUM_QUALITY;
        }
    }

    abstract int getDelta();
}
