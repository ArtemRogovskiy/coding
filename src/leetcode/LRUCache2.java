package leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache2 {

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
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

    Map<Integer, Node<Integer>> map;
    DoublyList<Integer> dList;
    int capacity;
    int size;

    public LRUCache2(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        dList = new DoublyList<>();
    }

    public int get(int key) {
        Node<Integer> n = map.get(key);
        if (n == null) {
            return -1;
        }
        increasePriority(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node<Integer> newNode = new Node<>(key, value);
        if (map.containsKey(key)) {
            Node<Integer> node = map.get(key);
            dList.removeNode(node);
            size--;
        } else if (size == capacity) {
            Node<Integer> removed = dList.removeEldest();
            map.remove(removed.key);
            size--;
        }
        map.put(key, newNode);
        dList.addNode(newNode);
        size++;
    }

    private void increasePriority(Node<Integer> node) {
        dList.removeNode(node);
        dList.addNode(node);
    }


    private static class DoublyList<T> {
        Node<T> head;
        Node<T> tail;
        int size;

        DoublyList() {
            size = 0;
            head = new Node<>();
            tail = new Node<>();
            head.prev = tail;
            tail.next = head;
        }

        public void addNode(Node<T> n) {
            Node<T> tmp = head.prev;
            head.prev = n;
            n.prev = tmp;
            tmp.next = n;
            n.next = head;
            size++;
        }

        public void removeNode(Node<T> n) {
            if (size <= 0) {
                throw new IllegalStateException();
            }
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }

        public Node<T> removeEldest() {
            if (size <= 0) {
                throw new IllegalStateException();
            }
            Node<T> tmp = tail.next;
            tmp.next.prev = tail;
            tail.next = tmp.next;
            size--;
            return tmp;
        }
    }

    private static class Node<T> {
        T key;
        T val;
        Node<T> next;
        Node<T> prev;

        Node() {
        }

        Node(T key, T val) {
            this.key = key;
            this.val = val;
        }
    }
}

