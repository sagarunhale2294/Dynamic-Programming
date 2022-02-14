package longest_common_subsequence;

import java.util.Arrays;

public class LCSMemoization {
	static int t[][] = new int[100][100];
	static {
		for(int row[] : t) {
			Arrays.fill(row,-1);
		}
	}
	private static int LCS(char s1[], char s2[], int m, int n) {
		if(m==0 || n==0) {
			return 0;
		}
		if(t[m][n] != -1) {
			return t[m][n];
		}
		if(s1[m-1] == s2[n-1]) {
			t[m][n] = 1 + LCS(s1, s2, m-1, n-1);
		} else {
			t[m][n] = Math.max(LCS(s1,s2,m,n-1), LCS(s1,s2,m-1,n));
		}
		return t[m][n];
	}

	public static void main(String[] args) {
		String x = "abcefghi", y= "abdefghji";
		System.out.println("Longest Common Subsequence length: " + LCS(x.toCharArray(),y.toCharArray(),x.length(),y.length()));
	}
}
