package com.lhx.linkedlist;

public class Solution25 {

	public static void main(String[] args) {
		Node head1 = LinkedList.createLinkedList(7);
		Node head2 = LinkedList.createLinkedList(3);
		LinkedList.showLinkedList(head1);
		LinkedList.showLinkedList(head2);
		LinkedList.showLinkedList(add(head1, head2));
	}
	
	public static Node add(Node n1, Node n2)
	{
		if (n1 == null) return n2;
		if (n2 == null) return n1;
		Node p = n1;
		Node q = n2;
		Node dummpy = new Node(0);
		Node r = null;
		int carry = 0;
		while (p != null || q != null)
		{
			if (p != null && q != null)
			{
				int sum = p.data + q.data + carry;
				Node n = new Node(sum % 10);
				if (r == null)
				{
					r = n;
					dummpy.next = r;
				} else {
					r.next = n;
					r = n;
				}
				p = p.next;
				q = q.next;
				carry = sum / 10;
			} else if (p != null)
			{
				int sum = p.data + carry;
				Node n = new Node(sum % 10);
				r.next = n;
				r = n;
				p = p.next;
				carry = sum / 10;
			} else {
				int sum = q.data + carry;
				Node n = new Node(sum % 10);
				r.next = n;
				r = n;
				q = q.next;
				carry = sum / 10;
			}
		}
		
		if (carry != 0)
		{
			r.next = new Node(carry);
		}
		return dummpy.next;
	}
	

}
