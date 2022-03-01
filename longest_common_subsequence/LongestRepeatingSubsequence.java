package longest_common_subsequence;

public class LongestRepeatingSubsequence {
    static int t[][] = new int[100][100];
    public static int findLengthOfLongestRepeatingSubsequence(char x[], char y[], int m, int n) {
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if(x[i-1] == y[j-1] && i!=j) {
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
        String str = "aabcddee";
        // longest repeating subsequence here is : `ade`, hence o/p: 3
        System.out.println("The lenghth of Longest repeating subsequence is: " + findLengthOfLongestRepeatingSubsequence(str.toCharArray(), str.toCharArray(), str.length(), str.length()));
    }
}
