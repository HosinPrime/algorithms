package com.lhx.arrandstrings;

public class Solution17 {

	//书上的方法是以层来进行交换，我们这里利用轴对称交换和对角线对称交换来进行旋转
	
	
	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		showMat(mat);
		rotate(mat);
		showMat(mat);

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
	
	public static void rotate(int[][] mat)
	{
		int n = mat.length;
		//以中心线为轴交换
		for (int i = 0; i < n; i++)
		{
			for (int j = 0 ; j < n/2; j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[i][n-1-j];
				mat[i][n-1-j] = temp;
			}
		}
		//以对角线为轴进行交换
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n-1-i; j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[n-1-j][n-1-i];
				mat[n-1-j][n-1-i] = temp;
			}
		}		
	}
	


}
