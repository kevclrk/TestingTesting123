package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val item = Item("item1")
        collection.addItem(item)

        assert(collection.size() == 1) { "Item was not added to the collection" }

        val itemFound = (0 until collection.size()).any { index ->
            collection.get(index).name == item.name
        }

        assert(itemFound) { "Collection does not contain the added item" }
    }


    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        val item1 = Item("item1")
        val item2 = Item("item1")
        val item3 = Item("item2")

        collection.addItem(item1)
        collection.addItem(item2)
        collection.addItem(item3)

        assert(collection.size() == 2) { "Collection size is incorrect, duplicate items were added" }

        val item1Found = (0 until collection.size()).any { index ->
            collection.get(index).name == item1.name
        }
        assert(item1Found) { "Collection should contain item1" }

        val item3Found = (0 until collection.size()).any { index ->
            collection.get(index).name == item3.name
        }
        assert(item3Found) { "Collection should contain item3" }

        val duplicateCount = (0 until collection.size()).count { index ->
            collection.get(index).name == item2.name
        }
        assert(duplicateCount == 1) { "Duplicate item was added" }
    }


    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}