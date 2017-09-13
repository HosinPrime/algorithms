package com.lhx.linkedlist;

import java.util.Stack;

class Result {
	Node node;
	boolean result;
	public Result(Node node, boolean result)
	{
		this.node = node;
		this.result = result;
	}
}

public class Solution26 {

	public static void main(String[] args) {
		Node head1 = new Node(3);
		head1.next = new Node(1);
		head1.next.next = new Node(3);
		Node head2 = new Node(4);
		head2.next = new Node(1);
		head2.next.next = new Node(1);
		head2.next.next.next = new Node(4);
		LinkedList.showLinkedList(head1);
		LinkedList.showLinkedList(head2);
		System.out.println(isPalindrome(head1));
		System.out.println(isPalindrome(head2));
		System.out.println(isPalindrome2(head1));
		System.out.println(isPalindrome2(head2));
	}
	
	//方法一，翻转后比较
	//方法二，用栈保存前一半链表，然后和后半部分比较，中间可以用两倍指针速度找到
	public static boolean isPalindrome(Node head)
	{
		if (head == null) return true;
		Stack<Integer> stack = new Stack<Integer> ();
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			stack.push(slow.data);
			slow  = slow.next;
		}
		if (fast != null)
		{
			slow = slow.next;
		}
		while (slow != null)
		{
			if (slow.data != stack.pop()) return false;
			slow = slow.next;
		}
		
		return true;
		
	}
	
	
	//方法3，递归利用长度len作为递归出口，每次减少2那么当len = 1或者0的时候就说明到了中间
	//然后我们就可以把中间的next节点存到result中，那么每次我们都从result中取出该节点，然后它的next就是与
	//递归回去的那部分相对称的那个结点
	public static boolean isPalindrome2(Node head)
	{
		if (head == null) return true;
		int len = lenOfLinkedList(head);
		Result r = dfs(head, len);
		return r.result;
	}
	public static Result dfs(Node head, int len)
	{
		if (len == 0)
		{
			return new Result(head, true);
		}
		if (len == 1)
		{
			return new Result(head.next, true);
		}
		
		Result r = dfs(head.next, len - 2);
		if (!r.result)
		{
			return r;
		}
		if (r.node.data == head.data)
		{
			r.result = true;
			r.node = r.node.next;
		} else {
			r.result = false;
		}
		
		return r;
		
	}
	
	public static int lenOfLinkedList(Node head)
	{
		int len = 0;
		while (head != null)
		{
			len++;
			head = head.next;
		}
		
		return len;
	}

}
