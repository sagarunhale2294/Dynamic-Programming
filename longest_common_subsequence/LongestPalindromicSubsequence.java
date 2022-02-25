package longest_common_subsequence;

public class LongestPalindromicSubsequence {
    static int t[][] = new int[100][100];
    private static int LCS(char x[], char y[], int m, int n) {
        for (int i=0; i<m+1; i++) {
            for (int j=0; j<n+1; j++) {
                if(i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if(x[i-1] == y[j-1]) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                    }
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        // find the longest pallindromic substring for a given string
        String s1 = "abdegedbstv";
        String s2 = new StringBuffer(s1).reverse().toString();
        System.out.println("Longest pallindromic subsequence length is =" + LCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }
}
