package longest_common_subsequence;

public class LCSRecursive {
	
	public static int longestCommonSubsequence(char x[], char y[], int m, int n) {
		if(m==0 || n==0) {
			return 0;
		}
		if(x[m-1] == y[n-1]) {
			return 1 + longestCommonSubsequence(x, y, m-1, n-1);
		} else {
			return Math.max(longestCommonSubsequence(x, y, m-1, n), longestCommonSubsequence(x, y, m, n-1));
		}
	}

	public static void main(String[] args) {
		String x = "abcefghi", y= "abdefghji";
		System.out.println("Longest Common Subsequence length: " + longestCommonSubsequence(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
	}

}
