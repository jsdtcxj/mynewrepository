package org.fkit.springboot.test;

import java.util.HashMap;
import java.util.Map;

public class TestCache {
	public static void main(String[] args) {
		TestCache cache = new TestCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}
	
	class Node{
        public int key;
        public int val;
        public Node prev;
        public Node next;
    }
	
	private int capacity = 0;
    private int size = 0;
    private Map<Integer, Node> map = new HashMap();
    private Node head = null;
    private Node tail = null;
    
    public TestCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node != null) {
            moveToHead(node);
        }
        return node == null ? -1 : node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.val = value;
            node.next = head.next;
            if(head.next == null) {
            	tail.prev = node;
            } else {
            	head.next.prev = node;
            }
            head.next = node;
            map.put(key, node);
            if(size < capacity) {
                size++;
            } else {
            	map.remove(tail.prev.val);
                if(capacity == 1) {
                    tail.prev = node;
                    node.next = null;
                } else {
                    tail.prev = tail.prev.prev;
                    tail.prev.next = null;
                }
            }
        }
    }
    
    public void moveToHead(Node node) {
        if(node != head.next) {
            if(node == tail.prev) {
                tail.prev = node.prev;
                tail.prev.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
        }
    }
}
