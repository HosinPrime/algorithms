package arraysandstrings;

class Node {
	String key;
	int value;
	Node next = null;
	public Node(String key, int value)
	{
		this.key = key;
		this.value = value;
	}
}


public class HM {
	
//实现一个hashMap, 假设string到int
	private Node[] node = new Node[17];
	
	public static void main(String[] args) {
		HM map = new HM();
		
		map.put("lhx", 183);
		map.put("bbb", 4);
		System.out.println(map.get("ww"));
	}
	public HM()
	{
		for(int i = 0 ; i < 17; i++)
		{
			node[i] = new Node("", -1);
		}
	}
	
	public void put(String s, int value)
	{
		int hc = s.hashCode();
		int position = hc % 17;
		Node p = node[position];
		while( p.next != null) p = p.next;
		Node newNode = new Node(s, value);
		p.next = newNode;
	}
	
	public int get(String s)
	{
		int hc = s.hashCode();
		int position = hc % 17;
		Node p = node[position].next;
		while(p != null)
		{
			if(p.key.equals(s)) return p.value;
			else {
				p = p.next;
			}
		}
		return -1;
	}
	
	
	
	
	
	

}
