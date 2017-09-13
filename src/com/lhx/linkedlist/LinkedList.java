package com.lhx.linkedlist;

public class LinkedList {
		
		
		public static Node createLinkedList(int len)
		{
			Node head = new Node(1);
			for (int i = len; i > 1; i--)
			{
				Node newNode = new Node(9);
				newNode.next = head.next;
				head.next = newNode;
			}
			
			return head;
		}
		
		public static void showLinkedList(Node head)
		{
			Node p = head;
			while(p != null)
			{
				System.out.print(p.data + " ");
				p = p.next;
			}
			System.out.println();
		}
		public static Node deleteX(Node head, int x)
		{
			Node p = head;
			if (p == null) return p;
			if (p.data == x)
			{
				head = head.next;
				return head;
			}
			while (p.next != null)
			{
				if (p.next.data == x)
				{
					p.next = p.next.next;
					return head;
				}
				p = p.next;
			}
			
			return head;
		}
		
		public static Node reverse(Node head)
		{
			if (head.next == null) return head;
			Node newHead = reverse(head.next);
			head.next.next = head;
			head.next = null;
			return newHead;
		}
}
