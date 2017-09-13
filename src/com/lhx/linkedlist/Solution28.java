package com.lhx.linkedlist;

public class Solution28 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next= new Node(5);
		head.next.next.next.next.next = head.next.next;
		System.out.println(findBeginning(head).data);

		
		

	}
	//就用快慢指针找就好
	public static Node findBeginning(Node head)
	{
		if (head == null) return null;
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) break;
		}
		
		if (fast == null || fast.next == null) return null;
		slow = head;
		while (slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
	}

}
