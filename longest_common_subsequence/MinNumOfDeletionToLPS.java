package longest_common_subsequence;

public class MinNumOfDeletionToLPS {
    static int t[][] = new int[100][100];
    private static int LPS(String str1) {
        String str2 = new StringBuffer(str1).reverse().toString();
        return LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
    }

    private static int LCS(char x[], char y[], int m, int n) {
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if(x[i-1]==y[j-1]) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                    }
                }
            }
        }
        return t[m][n];
    }

    private static int findMinNumberOfDeletionToMakePallindrome(String str) {
        return str.length() - LPS(str);
    }
    
    public static void main(String[] args) {
        String str = "agbedeba";
        System.out.println("Number of deletion required to convert into pallindrome is:" + findMinNumberOfDeletionToMakePallindrome(str));
    }
}
