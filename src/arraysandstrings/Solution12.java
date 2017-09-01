package arraysandstrings;

import java.util.Arrays;

//判断一个字符串是否是另一个字符串的排列组合 例如dog是god的排列组合

public class Solution12 {

	public static void main(String[] args) {
		String s1 = "aaa";
		String s2 = "aaa";
		System.out.println(isPermutation(s1, s2));
		System.out.println(ispermutation2(s1, s2));

	}
	//直接将两个字符串排序，看是否相等
	public static boolean isPermutation(String s1,String s2)
	{
		if (s1.length() != s2.length()) return false;
		return sortString(s1).equals(sortString(s2));
	}
	public static String sortString(String s)
	{
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	//也可以统计每一个字符出现的次数来判断
	public static boolean ispermutation2(String s1, String s2)
	{
		if (s1.length() != s2.length()) return false;
		int[] flag = new int[128];
		for (int i = 0; i < s1.length(); i++)
		{
			int val = s1.charAt(i);
			flag[val]++;
		}
		for (int i = 0; i < s2.length(); i++)
		{
			int val = s2.charAt(i);
			flag[val]--;
			if(flag[val] < 0) return false;    //因为s1和s2的长度相等，所有如果两单词不同的话肯定有个值会
											   //小于0
		}
		return true;
	}
}
