package com.gildedrose;

class RegularItem extends ItemExtended{

    RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    int getDelta(){
        switch (name) {
            case "Aged Brie":
                return sellIn >= 0 ? 1 : 2;
            case "Conjured Mana Cake":
                return sellIn >= 0 ? -2 : -4;
            default:
                return sellIn >= 0 ? -1 : -2;
        }

    }
}
