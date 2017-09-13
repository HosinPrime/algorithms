package com.lhx.linkedlist;

public class Solution24 {
	//把一个链表以一个数为pivot断开，直接断即可
	public static void main(String[] args) {
		Node first = LinkedList.createLinkedList(5);
		LinkedList.showLinkedList(first);
		LinkedList.showLinkedList(partition(first, 3));

	}
	
	public static Node partition(Node first, int pivot)
	{
		Node head = first;
		Node tail = first;
		Node p = first.next;
		first.next = null;
		while (p != null)
		{
			Node next = p.next;
			p.next = null;
			if (p.data < pivot)
			{
				p.next = head;
				head = p;
			} else {
				tail.next = p;
				tail = p;
			}
			p = next;
		}
		return head;
	}

}
