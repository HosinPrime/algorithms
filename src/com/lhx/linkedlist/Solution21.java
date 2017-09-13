package com.lhx.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Solution21 {

	public static void main(String[] args) {
		Node head = LinkedList.createLinkedList(7);
		LinkedList.showLinkedList(head);
		deleteDups2(head);
		LinkedList.showLinkedList(head);

	}
	
	//方法一，hashtable,需要额外开数组
	public static void deleteDups(Node head)
	{
		Set<Integer> set = new HashSet<Integer> ();
		Node pre = null;
		Node p = head;
		while (p != null)
		{
			if (set.contains(p.data))
			{
				pre.next = p.next;
			} else {
				set.add(p.data);
				pre = p;
			}
			p = p.next;
		}
	}
	
	//方法二，双重循环
	public static void deleteDups2(Node head)
	{
		if (head == null) return;
		Node p = head;
		while (p != null)
		{
			Node q = p;
			int x = p.data;
			while (q.next != null)
			{
				if (q.next.data == x)
				{
					q.next = q.next.next;
				} else {
				q = q.next;
				}
			}
			p = p.next;
		}
	}
	
	

}
