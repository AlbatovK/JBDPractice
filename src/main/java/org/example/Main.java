package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

class SimpleHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 100;
    private final List<List<Entry<K, V>>> table;

    public SimpleHashTable() {
        table = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table.add(new ArrayList<>());
        }
    }

    private int hash(K key) {
        int hash = Math.abs(Objects.hashCode(key));
        return hash % DEFAULT_CAPACITY;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        List<Entry<K, V>> chain = table.get(hash);
        for (Entry<K, V> e : chain) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        chain.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int hash = hash(key);
        List<Entry<K, V>> chain = table.get(hash);
        for (Entry<K, V> e : chain) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }
}

class DummyClass {
    int code = 0;
    public DummyClass(int code) {
        this.code = code;
    }
    @Override
    public int hashCode() {
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        DummyClass dummyClass = (DummyClass) obj;
        return code == dummyClass.code;
    }
}


public class Main {
    public static void main(String[] args) {
        SimpleHashTable<DummyClass, Integer> table = new SimpleHashTable<>();

        DummyClass a = new DummyClass(1);
        DummyClass b = new DummyClass(2);
        DummyClass c = new DummyClass(3);
        table.put(a, 1);
        table.put(b, 2);
        table.put(c, 3);
        a.code = 10;

        System.out.println(table.get(a));
        //System.out.println(table.get("nonexistent"));
    }
}
