package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private val MAX_QUALITY = 50

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.quality = item.quality - 1
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.sellIn in 6..10) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 2
                            }
                        }
                    }
                }
            }

            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
                                item.quality = item.quality - 1
                            }
                        }
                    } else {
                        item.quality = 0
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1
                    }
                }
            }
            if(item.quality>MAX_QUALITY) {
                item.quality = MAX_QUALITY
            }
        }
    }

}

