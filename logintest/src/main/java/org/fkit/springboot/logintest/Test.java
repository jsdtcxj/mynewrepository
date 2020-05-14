package org.fkit.springboot.logintest;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		t.insert("123.1.24.128", "hello.world");
		t.insert("123.12.24.18", "hello.world.cn");
		System.out.println(t.get("123.12.24.18"));
		System.out.println(t.get("123.1.24.128"));
		System.out.println(t.get("123.1.2.128"));
	}
	
	private TrieNode root = new TrieNode();
	
	public void insert(String ip, String url) {
		if(ip != null && url != null) {
			TrieNode current = root;
			for(int i = 0; i < ip.length(); i++) {
				int index = getIndex(ip.charAt(i));
				TrieNode child = current.children[index];
				if(child == null) {
					 child = new TrieNode();
					 current.children[index] = child; 
				}
				current = child;
			}
			current.isLeaf = true;
			current.url = url;
		}
	}
	
	public String get(String ip) {
		if(ip == null) return null;
		
		TrieNode current = root;
		for(int i = 0; i < ip.length(); i++) {
			int index = getIndex(ip.charAt(i));
			TrieNode child = current.children[index];
			if(child == null) {
				return null;
			}
			current = child;
		}
		return current.isLeaf ? current.url : null;
	}
	
	public int getIndex(char c) {
		return c == '.' ? 10 : c-'0';
	}
	
	static class TrieNode {
		public boolean isLeaf = false;
		public TrieNode[] children = new TrieNode[11];
		public String url = null;

	}
}
