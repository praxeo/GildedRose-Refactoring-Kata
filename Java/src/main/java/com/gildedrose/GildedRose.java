package com.gildedrose;

class GildedRose {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name) {
                case AGED_BRIE: {
                    item.sellIn -= 1;
                    int qualityMod;
                    if(item.sellIn < 0) {
                        qualityMod = 2;
                    } else {
                        qualityMod = 1;
                    }
                    while(qualityMod > 0 && item.quality < 50) {
                        item.quality += 1;
                        qualityMod -= 1;
                    }
                    break;
                }
                case BACKSTAGE_PASSES: {
                    item.sellIn -= 1;
                    int qualityMod = 1;
                    if(item.sellIn < 0) {
                        item.quality = 0;
                    } else {
                        if (item.sellIn < 11) {
                            qualityMod += 1;
                        }
                        if (item.sellIn < 6) {
                            qualityMod += 1;
                        }
                        while(qualityMod > 0 && item.quality < 50) {
                            item.quality += 1;
                            qualityMod -= 1;
                        }
                    }
                    break;
                }
                case SULFURAS: {
                    // DO NOTHING
                    break;
                }
                default: {
                    item.sellIn -= 1;
                    int qualityMod;
                    if (item.sellIn < 0) {
                        qualityMod = 2;
                    } else {
                        qualityMod = 1;
                    }
                    while (qualityMod > 0 && item.quality > 0) {
                        item.quality -= 1;
                        qualityMod -= 1;
                    }
                    break;
                }
            }
        }
    }
}
