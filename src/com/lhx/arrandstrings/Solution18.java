package com.lhx.arrandstrings;

public class Solution18 {

	public static void main(String[] args) {
		int[][] mat = {{0,2,1}, {0,0,1}, {2,3,0}};
		showMat(mat);
		System.out.println("................");
		setZeros(mat);
		showMat(mat);
		
		

	}
	
	
	//easy way to do 就是用一个行数组和列数组记录
	//可选择的我们可以用第一行和第一列来记录，但是前提是我们得先看一下这一行（列）中是否已经有0需要置0
	public static void setZeros(int[][] mat)
	{
		boolean zeroInrow = false;
		boolean zeroIncol = false;
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++)
		{
			if (mat[i][0] == 0)
			{
				zeroIncol = true;
				break;
			}
		}
		
		for (int j = 0; j < mat[0].length; j++)
		{
			if (mat[0][j] == 0)
			{
				zeroInrow = true;
				break;
			}
		}
		
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				if (mat[i][j] == 0)
				{
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < m; i++)
		{
			if (mat[i][0] == 0) setrowZeros(mat, i);
		}
		for (int j = 1; j < n; j++)
		{
			if (mat[0][j] == 0) setColZeros(mat, j);
		}
		if (zeroInrow) setrowZeros(mat, 0);
		if (zeroIncol) setColZeros(mat, 0);
 	}
	public static void setrowZeros(int[][] mat,int row)
	{
		for (int j = 0; j < mat[0].length; j++)
		{
			mat[row][j] = 0;
		}
	}
	public static void setColZeros(int[][] mat, int col)
	{
		for (int i = 0; i < mat.length; i++)
		{
			mat[i][col] = 0;
		}
	}
	public static void showMat(int[][] mat)
	{
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[0].length; j++)
			{
				System.out.print(mat[i][j] + " ") ;
			}
			System.out.println();
		}
	}
	

}
