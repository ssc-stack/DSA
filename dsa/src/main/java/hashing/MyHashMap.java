package hashing;

import java.util.LinkedList;

class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;
    private LinkedList<Entry<K, V>>[] table;
    private int size; // Number of key-value pairs in the map

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (rehashRequired()) {
            rehash();
        }
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    private boolean rehashRequired() {
        return (float) size / table.length >= LOAD_FACTOR_THRESHOLD;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        // Create a new table with double the capacity
        int newCapacity = table.length * 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new LinkedList<>();
        }

        // Rehash all entries
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                int index = Math.abs(entry.key.hashCode()) % newCapacity;
                newTable[index].add(entry);
            }
        }

        // Replace the old table with the new table
        table = newTable;
    }

    private int getIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5); // This might trigger a rehash depending on initial capacity

        System.out.println("Value for 'one': " + map.get("one")); // Output: 1
        System.out.println("Value for 'two': " + map.get("two")); // Output: 2
        System.out.println("Value for 'five': " + map.get("five")); // Output: 5

        map.remove("two");
        System.out.println("Value for 'two' after removal: " + map.get("two")); // Output: null
    }
}

