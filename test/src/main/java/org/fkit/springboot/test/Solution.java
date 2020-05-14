package org.fkit.springboot.test;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] as = {"flower","flow","flight"};
//		System.out.println(s.longestCommonPrefix(as));
		int[] num1 = {0,0};
//		s.nextPermutation(num1);
//		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		int[][] matrix = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
//        s.rotate(matrix);
//        for(int i = 0; i < matrix.length; i++) {
//        	for(int j = 0; j < matrix[0].length; j++) {
//        		System.out.print(matrix[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        String[] strs = {"hot","dot","dog","lot","log","cog"};
        int[] A = {824,938,1399,5607,6973,5703,9609,4398,8247};
        int[] B = {1,2,4,5,3,6,7};
        int[] C = {4,5,2,6,7,3,1};
        int[][] points = {{0,0,0},{0,1,0},{0,0,0}};
        String str = "110101011011000011011111000000";
        String a = "hit";
        String b = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
//        ListNode head = s.new ListNode(4);
//        ListNode n1 = s.new ListNode(2);
//        head.next = n1;
//        ListNode n2 = s.new ListNode(1);
//        n1.next = n2;
//        n1 = s.new ListNode(2);
//        n2.next = n1;
//        n1.next = null;
//        ListNode r = s.sortList(head);
        System.out.println(s.constructFromPrePost(B, C));
//        System.out.println((char)('A'+25));
//        System.out.println(-3/(-2));
//        s.wiggleSort(B);
//        Stack<Integer> stack = new Stack();
//        stack.push(1);stack.push(2);stack.push(3);
//        s.reverseStack(stack);
//        while(!stack.isEmpty()) {
//        	System.out.println(stack.pop());
//        }
//        System.out.println();
        
   }
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	
	private int[] pre = null;
    private int index = 0;
    private Map<Integer,Integer> map = new HashMap();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        for(int i = 0; i <= post.length-1; i++) {
            map.put(post[i], i);
        }
        return build(0, pre.length-1);
    }
    
    public TreeNode build(int start, int end) {
        TreeNode node = null;
        if(start <= end) {
            int num = pre[index++];
            int mid = map.get(pre[index]);
            node = new TreeNode(num);
            if(mid > start) {
                node.left = build(start, mid);
                node.right = build(mid+1, end-1);
            }
        }
        return node;
    }
 }
