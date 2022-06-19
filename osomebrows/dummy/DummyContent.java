package com.osomebrows.freddy.osomebrows.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 */
public class DummyContent {

    /**
     * An array of sample items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Products"));
        addItem(new DummyItem("2", "Q&A"));
        addItem(new DummyItem("3", "Salons"));
        addItem(new DummyItem("3", "Gallery"));
        addItem(new DummyItem("3", "Contact us"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class DummyItem {
        public String id;
        public String name;

        public DummyItem(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

