package com.lhx.linkedlist;

public class Solution23 {
 
	//删除中间的节点，注意这里给出的Node是中间的节点
	public static void main(String[] args) {
		Node head = LinkedList.createLinkedList(5);
		LinkedList.showLinkedList(head);
		
	}
	//将Mid节点的后一个结点的值复制到mid结点中，再把那个结点删除掉就可以了
	public static boolean deleteNode(Node mid)
	{
		if (mid == null || mid.next == null) return false;
		Node next = mid.next;
		mid.data = next.data;
		mid.next = next.next;
		return true;
	}

}
