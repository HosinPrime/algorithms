package com.lhx.linkedlist;

public class Solution22 {

	public static void main(String[] args) {
		Node head = LinkedList.createLinkedList(5);
		LinkedList.showLinkedList(head);
		int k = 3;
		System.out.println(findLastKth(head, k));
		findLastKth2(head, k);
		System.out.println(findLastKth3(head, k));
	}
	
	//方法1，纪录长度 move (len-k)步
	public static int findLastKth(Node head,int k )
	{
		Node p = head;
		int len = 0;
		while(p != null)
		{
			len++;
			p = p.next;
		}
		if (k > len) return -1; //can't get 
		p = head;
		for (int i = 0; i < (len - k); i++)
		{
			p = p.next;
		}
		return p.data;
		
	}
	
	//方法2，递归，先找到最后一个，然后不断向前找,这需要o(n)的空间，因为要调用栈
	public static int  findLastKth2(Node head,int k)
	{
		if (head == null) return 0;
		int index = findLastKth2(head.next, k) + 1;
		if (index == k)
		{
			System.out.println("最后第k个数的值是  " + head.data);
		}
		return index;
	}
	
	//方法3，两个指针，一个先走K步
	public static int findLastKth3(Node head, int k)
	{
		if (head == null) return -1;
		Node p = head;
		Node q = head;
		for (int i = 0; i < k; i++)
		{
			if (p == null) return -1;
			p = p.next;
		}
		while (p != null)
		{
			p = p.next;
			q = q.next;
		}
		return q.data;
	}

}
