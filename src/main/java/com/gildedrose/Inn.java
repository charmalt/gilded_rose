package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class Inn {

    private Item[] items;

    Inn(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (Item item : items) {
            ItemExtended itemMap =  createItem(item);
            itemMap.updateSellIn();
            itemMap.updateItemQuality();
            item.quality = itemMap.quality;
            item.sellIn = itemMap.sellIn;
        }

    }

    ItemExtended createItem(Item item) {

        Map<String, ItemExtended> map = new HashMap<>();

        map.put("Backstage passes to a TAFKAL80ETC concert", new BackStagePass(item.name, item.sellIn, item.quality));
        map.put("Sulfuras, Hand of Ragnaros", new Sulfuras(item.name, item.sellIn, item.quality));

        if (map.get(item.name) == null){
            return new RegularItem(item.name, item.sellIn, item.quality);
        } else {
            return map.get(item.name);
        }

    }

}
