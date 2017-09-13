package com.lhx.linkedlist;

public class Solution27 {

	public static void main(String[] args) {
		Node n1 = new Node(3);
		n1.next = new Node(1);
		n1.next.next = new Node(5);
		n1.next.next.next = new Node(9);
		Node n2 = new Node(4);
		n2.next = new Node(6);
		n2.next.next = n1;
		LinkedList.showLinkedList(n1);
		LinkedList.showLinkedList(n2);
		System.out.println(findIntersection(n1, n2).data);
		
	}
	
	public static Node findIntersection(Node n1, Node n2)
	{
		if (n1 == null || n2 == null) return null;
		int len1 = getLength(n1);
		int len2 = getLength(n2);
		int move = Math.abs(len1 - len2);
		Node fast = len1 > len2 ? n1 : n2;
		Node slow = len1 > len2 ? n2 : n1;
		for (int i = 0; i < move; i++) fast = fast.next;
		while (fast != slow)
		{
			if (fast == null || slow == null) return null;
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}

	
	public static int getLength(Node n)
	{
		int count = 0;
		while(n != null)
		{
			count++;
			n = n.next;
		}
		return count;
	}
	
	
	
	

}
