package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun decreaseSellIn() {
        val items = arrayOf(Item("random product", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        app.updateQuality()
        assertEquals(8, app.items[0].sellIn)
    }

    @Test
    fun decreaseQuality() {
        val items = arrayOf(Item("random product", 10, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].quality)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun decreaseQualityAfterSellIn() {
        val items = arrayOf(Item("random product", 0, 6))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].quality)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun qualityIsNeverNegative() {
        val items = arrayOf(Item("random product", 0, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun maximumQuality() {
        val items = arrayOf(Item("random product", 12, 100))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstageTAFKAL80ETCQualityIncreases10DaysBeforeSellIn() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 11, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(41, app.items[0].quality)
        assertEquals(10, app.items[0].sellIn)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun backstageTAFKAL80ETCQualityIncreases5DaysBeforeSellIn() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 6, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
        assertEquals(5, app.items[0].sellIn)
        app.updateQuality()
        assertEquals(45, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun backstageTAFKAL80ETCQualityIsZeroAfterConcert() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 1, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    //- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    //	Quality drops to 0 after the concert
}


