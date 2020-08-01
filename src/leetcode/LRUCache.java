package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    private Map<Integer, DoublyList.Node> cache;
    private DoublyList list;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        list = new DoublyList();
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyList.Node n = cache.get(key);
        if (n == null) {
            return -1;
        }
        list.replaceToHead(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoublyList.Node node = cache.get(key);
            node.value = value;
            list.replaceToHead(node);
        } else {
            if (capacity == cache.size()) removeLeastRecentlyUse();
            DoublyList.Node newNode = new DoublyList.Node(key, value);
            cache.put(key, newNode);
            list.add(newNode);
        }
    }

    private void removeLeastRecentlyUse() {
        int key = list.remove(list.tail.next);
        cache.remove(key);
    }
}

class DoublyList {

    Node head;
    Node tail;
    private int size;

    DoublyList() {
        head = new Node();
        tail = new Node();
        tail.next = head;
        head.prev = tail;
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(){}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    void add(Node node) {
        head.prev.next = node;
        node.prev = head.prev;
        head.prev = node;
        node.next = head;
        size++;
    }

    void replaceToHead(Node node) {
        remove(node);
        add(node);
    }

    int remove(Node node) {
        if (size < 1) {
            throw new IllegalStateException();
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.key;
    }

}
