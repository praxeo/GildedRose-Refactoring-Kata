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
                    if(item.quality < 50) {
                        item.quality += 1;
                    }
                    item.sellIn -= 1;
                    if(item.quality < 50 && item.sellIn < 0) {
                        item.quality += 1;
                    }
                    break;
                }
                case BACKSTAGE_PASSES: {
                    if(item.quality < 50) {
                        item.quality += 1;
                    }
                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality += 1;
                    }
                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality += 1;
                    }
                    item.sellIn -= 1;
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                }
                case SULFURAS: {
                    // DO NOTHING
                    break;
                }
                default: {
                    if (item.quality > 0) {
                        item.quality -= 1;
                    }
                    item.sellIn -= 1;
                    if (item.quality > 0 && item.sellIn < 0) {
                        item.quality -= 1;
                    }
                    break;
                }
            }
        }
    }
}
