package com.gildedrose;

class Inn {

    private ItemExtended[] items;

    Inn(ItemExtended[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (ItemExtended item : items) {
            item.updateSellIn();
            item.updateItemQuality();
        }

    }

}
