package com.company;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;

        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + '}';
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;


    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int m) {
        M = m;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value) {
        HashNode<K, V> temp = chainArray[hash(key)];
        if (temp == null) {
            chainArray[hash(key)] = new HashNode<K, V>(key, value);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new HashNode<K, V>(key, value);
        }
        size++;
    }

    public V get(K key) {
        HashNode<K, V> temp = chainArray[hash(key)];
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> temp = chainArray[hash(key)];
        if (temp.key == key) {
            chainArray[hash(key)] = temp.next;
            size--;
            return temp.value;
        } else {
            HashNode<K, V> lag = null;
            while (temp != null && temp.key != key) {
                lag = temp;
                temp = temp.next;
            }
            if (temp.key == key) {
                lag.next = temp.next;
                size--;
                return temp.value;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> temp : chainArray) {
            while (temp != null) {
                if (temp.value == value) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> temp : chainArray) {
            while (temp != null) {
                if (temp.value == value) {
                    return temp.key;
                }
                temp = temp.next;
            }
        }
        return null;
    }
}
