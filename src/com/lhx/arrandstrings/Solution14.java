package com.lhx.arrandstrings;


//判断一个字符串是否是一个回文串的排列组合


public class Solution14 {
	public static void main(String[] args)
	{
		String s = "Tact Coa";
		System.out.println(isPermutationOfPalindrome(s));
		System.out.println(isPermutationOfPalindrome2(s));
		System.out.println(isPermutationOfPalindrome3(s));
		
	}
	
//方法1的话记录每一个字符出现的次数，在一个回文串中（包括奇数和偶数长度）同一个字符最多只能有一个的出现次数是奇数
	public static boolean isPermutationOfPalindrome(String s)
	{
		if (s.length() == 0) return true;
		int[] map = new int[26];
		String newS = s.toLowerCase();
		for (int i = 0 ; i < newS.length(); i++)
		{
			int charNumber = getCharNumber(newS.charAt(i));
			if (charNumber == -1) continue;
			map[charNumber]++;
		}
		boolean flag = false;
		for (int i = 0 ; i < 26; i++)
		{
			if(map[i] % 2 == 1)
			{
				
				if( flag) return false;
				flag = true;
			}
		}
		return true;
		
	}
	public static int getCharNumber(char c)
	{
		int num = c - 'a';
		if(num > 25 || num < 0) return -1;
		return num;
	}
	
//方法2，优化不会很大，就是在一边检查一边记录奇数次数字符的个数
	public static boolean isPermutationOfPalindrome2(String s)
	{
		int oddCount = 0;
		String newS = s.toLowerCase();
		int[] map = new int[26];
		for (int i = 0;i < s.length(); i++)
		{
			int charNum = getCharNumber(newS.charAt(i));
			if (charNum == -1) continue;
			map[charNum]++;
			if (map[charNum] %2 == 1) oddCount++;
			else oddCount--;
		}
		return oddCount <= 1;
	}

	//方法3，我们也可以用一个32位int去记录26位字母，我们其实并不关心数目而是只关心是否是奇数还是偶数，那么我们
	//就每一次有一个字母出现就翻转它的奇偶性，用1代表奇，0代表偶，那么只要看最后这个数是否为0或者只有一位为1就可以
	public static boolean isPermutationOfPalindrome3(String s)
	{
		int bitVector = 0;
		for (char c : s.toLowerCase().toCharArray())
		{
			int charNumber = getCharNumber(c);
			if (charNumber == -1) continue;
			int mask = (1 << charNumber);
			if ((bitVector & mask) == 0)
			{
				bitVector |= mask;
			} else {
				bitVector &= ~mask;
			}
		}
		
		return bitVector == 0 || ((bitVector & (bitVector - 1)) == 0);
	}
	
	
	

}
