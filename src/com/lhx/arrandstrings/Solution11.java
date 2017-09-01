package com.lhx.arrandstrings;


//判断是否一个字符串中的字符是唯一的

public class Solution11 {

	public static void main(String[] args) {
		String s = "abcdee";
		System.out.println(isUnique(s));
		System.out.println(isUnique2(s));
		
	}
	
	public static boolean isUnique(String s)
	{
		if (s.length() ==0 || s.length() > 128) return false;
		boolean[] flag = new boolean[128];
		for (int i = 0; i < s.length(); i++)
		{
			int val = s.charAt(i);
			if (flag[val] == true) return false;
			flag[val] = true;
		}		
	
		return true;
	}
	
//	我们可以做一些简化工作，加入我们的输入就是a-z之间，那么我们可以将它映射到26位的数组中，
//	其实我们用一位int就可以了，因为int有32个位置
	public static boolean isUnique2(String s)
	{
		if(s.length() > 26) return false;
		int flag = 0; //共有32个特征位置
		for (int i = 0; i < s.length(); i++)
		{
			int val = s.charAt(i) - 'a';
			if ((flag & (1 << val)) > 0) return false;
			flag |= (1 << val);
		}
		return true;
	}
	//如果不能用其他任何的数据结构的话，我们就有o(n^2)的方法，双重循环来做
	//或者如果让将string排序的话，我们可以将它排序后（n*logn)后线性查找o(n)

}
