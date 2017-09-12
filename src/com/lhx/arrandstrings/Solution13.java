package com.lhx.arrandstrings;

//将一个字符串的空格替换成%20


public class Solution13 {
	public static void main(String[] args)
	{
		String s = "Mr jone Smith	";
		System.out.println(replaceSpace(s.toCharArray()));
	}
	
	public static String replaceSpace(char[] str)
	{
		int len = str.length;
		int space = 0;
		for (char c : str)
		{
			if (c == ' ') space++;
		}
		int newLen = len + space * 2;
		char[] newStr = new char[newLen];
		int i = 0;
		for (char c : str)
		{
			if (c == ' ')
			{
				newStr[i] = '%';
				newStr[i+1] = '2';
				newStr[i+2] = '0';
				i = i + 3;
			} else {
				newStr[i++] = c;
			}
		}
		return new String(newStr);
	}
}
