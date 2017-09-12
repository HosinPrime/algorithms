package com.lhx.arrandstrings;

public class Solution16 {

	public static void main(String[] args) {
		String s = "aabbbbcccdddeee";
		System.out.println(compress(s));
		System.out.println();

	}
	
	public static String compress(String s)
	{
		StringBuilder sb = new StringBuilder();
		int count = 0;  //times of the same character appear
		for (int i = 0; i < s.length(); i++)
		{
			count++;
			if (i + 1 >= s.length() || s.charAt(i+1) != s.charAt(i))
			{
				sb.append(s.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		
		return s.length() < sb.length() ? s : sb.toString();
	}
	
	//方法2的话是先把压缩后的字符串的长度就算出来，如果长度比原始的字符串还长的话我们就放弃
	//这样做的好处是如果事先就知道了压缩后长度反而没有变短，那么我们就不做操作
	//坏处是这样需要多进行一遍便利（在需要压缩的情况下）

}
