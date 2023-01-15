package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void qualityDegradesByOne() {
        Item[] items = new Item[] { new Item("foo", 1, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(99, app.items[0].quality);
    }

    @Test
    void qualityDegradesByTwoAfterSellBy() {
        Item[] items = new Item[] { new Item("foo", 0, 100)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(98, app.items[0].quality);
    }

    @Test
    void qualityFloorIsZero() {
        Item[] items = new Item[] { new Item("foo", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityRisesIfAgedBrie() {
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void qualityCapIsFifty() {
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality <= 50, "Quality should always be 50 or less");
    }

    @Test
    void SulfurasKeepsQualityAndSellby() {
        Item[] items = new Item[] { new Item(GildedRose.SULFURAS, 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality, "Sulfuras quality needs to stay the same");
        assertEquals(10, app.items[0].sellIn, "Sulfuras sellIn needs to stay the same");
    }

    @Test
    void qualityBackstagePasses() {
        Item[] items = new Item[]{new Item(GildedRose.BACKSTAGE_PASSES, 15, 15)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 16, "Backstage pass quality goes up by one when sellIn is more than ten days");

        app.items[0].sellIn = 10;
        app.updateQuality();
        assertEquals(app.items[0].quality, 18, "Backstage Pass quality should go up by 2 when 5 < sellIn <= 10");

        app.items[0].sellIn = 5;
        app.updateQuality();
        assertEquals(app.items[0].quality, 21, "Backstage Pass quality should go up by 3 when 0 < sellIn <= 5");

        app.items[0].sellIn = -1;
        app.updateQuality();
        assertEquals(app.items[0].quality, 0, "Backstage Pass quality goes to zero after the concert");


    }
}
