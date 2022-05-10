package com.company;

public class BST<K extends Comparable<K>, V> {
    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    private void recursivePut(K key, V value, Node node) {
        if (node.key.compareTo(key) > 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                return;
            }
            recursivePut(key, value, node.left);
        }
        if (node.key.compareTo(key) < 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                return;
            }
            recursivePut(key, value, node.right);
        }
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
        }
        recursivePut(key, value, root);
    }

    private V recursiveGet(K key, Node node) {
        if (key == node.key) {
            return node.value;
        }
        if (node.key.compareTo(key) > 0) {
            return recursiveGet(key, node.left);
        }
        if (node.key.compareTo(key) < 0) {
            return recursiveGet(key, node.right);
        }
        return null;
    }

    public V get(K key) {
        return recursiveGet(key, root);
    }
}
