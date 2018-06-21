package com.gildedrose;

class BackStagePass extends ItemExtended {

    private static final int MAXIMUM_QUALITY = 50;

    BackStagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    int getDelta(){

        if (sellIn <= 0 ){
            return -quality;
        }
        else if (quality < MAXIMUM_QUALITY) {
            if (sellIn > 10) { return 1; }
            else if (sellIn > 5) { return 2; }
            else { return 3; }
        }
        else {
            return 0;
        }

    }

}
