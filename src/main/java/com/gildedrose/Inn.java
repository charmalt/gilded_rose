package com.gildedrose;

class Inn {

    private Item[] items;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    Inn(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (Item item : items) {
            updateSellin(item);
            updateItemQuality(item);
        }

    }

    private void updateSellin(Item item){
        item.sellIn = item.name.equals("Sulfuras, Hand of Ragnaros") ? item.sellIn : item.sellIn - 1 ;
    }

    private void updateItemQuality(Item item){

        switch (item.name) {
            case "Aged Brie":
                changeValue(item, getDelta(item, 1, 2));
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                changeValue(item, getBackStageDelta(item));
                break;
            case "Conjured Mana Cake":
                changeValue(item, getDelta(item, -2, -4));
                break;
            default:
                changeValue(item, getDelta(item, -1, -2));
        }

    }

    private int getDelta(Item item, int AboveZeroSellIn, int BelowZeroSellIn){
        return item.sellIn >= 0 ? AboveZeroSellIn : BelowZeroSellIn;
    }

    private int getBackStageDelta(Item item){

        if (item.sellIn <= 0 ){
            return -item.quality;
        }
        else if (item.quality < MAXIMUM_QUALITY) {
            if (item.sellIn > 10) { return 1; }
            else if (item.sellIn > 5) { return 2; }
            else { return 3; }
        }
        else {
            return 0;
        }

    }

    private void changeValue(Item item, int delta){

        if (delta < 0){
            item.quality = (item.quality < -delta)||(-delta == item.quality) ? MINIMUM_QUALITY : item.quality + delta ;
        }
        else {
            item.quality = (MAXIMUM_QUALITY - item.quality) >= delta ? item.quality + delta : MAXIMUM_QUALITY;
        }
    }


}
