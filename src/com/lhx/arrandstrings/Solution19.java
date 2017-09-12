package com.lhx.arrandstrings;

public class Solution19 {
	//假设旋转的点将字符串分割为两份x和y
	//那么原来的字符串是xy旋转后是yx那么yx是xyxy的substring
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(isRotate(s1, s2));


	}
	
	public static boolean isRotate(String s1, String s2)
	{
		if (s1.length() != s2.length() ) return false;
		String s1s1 = s1 + s1;
		
		return s1s1.indexOf(s2) != -1;
	}

}
