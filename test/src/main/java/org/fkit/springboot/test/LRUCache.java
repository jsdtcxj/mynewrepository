package org.fkit.springboot.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
//		cache.put(1, 1);
		cache.put(2, 1);
		System.out.println(cache.get(2));//2
		cache.put(3, 2);//3
		System.out.println(cache.get(2));//-1
//		cache.put(4, 4);//4->3
//		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
//		System.out.println(cache.get(4));
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
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
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
            node.val = value;
            node.key = key;
            addToFirst(node);
            map.put(key, node);
            
            if(size < capacity) {
                size++;
            } else {
                map.remove(tail.prev.key);
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            }
        }
    }
    
    public void addToFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    public void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToFirst(node);
    }

}
