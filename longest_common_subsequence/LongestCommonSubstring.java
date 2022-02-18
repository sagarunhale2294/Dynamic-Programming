package longest_common_subsequence;

public class LongestCommonSubstring {
    static int t[][] = new int[100][100];
    public static int longestCommonSubstring(char x[], char y[], int m, int n) {
        for (int i=0; i<m+1; i++) {
            for (int j=0; j<n+1; j++) {
                if (i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if(x[i-1] == y[j-1]) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = 0;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                max = Math.max(max, t[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s1 = "abcdeghjkln", s2 = "abcfghjklm";
        System.out.println("Longest common substring's length: " + longestCommonSubstring(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }
}
