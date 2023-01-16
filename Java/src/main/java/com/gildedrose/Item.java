package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) throws IllegalArgumentException {
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("Quality should be a value from 0 to 50");
        }
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
