package longest_common_subsequence;

public class MinNumberOfInsertionToLPS {
    static int t[][] = new int[100][100];

    private static int LPS(char x[], char y[], int m, int n) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else {
                    if (x[i - 1] == y[j - 1]) {
                        t[i][j] = 1 + t[i - 1][j - 1];
                    } else {
                        t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                    }
                }
            }
        }
        return t[m][n];
    }

    private static void findNumberOfInsertionToLPS(String str) {
        String strRev = new StringBuffer(str).reverse().toString();
        int noOfInsertion = str.length() - LPS(str.toCharArray(), strRev.toCharArray(), str.length(), strRev.length());
        // Number of Deletion to Make LPS == Number of Insertion to Make LPS
        System.out.println("Number of insertion required to make a string pallindrome is: " + noOfInsertion);
    }

    public static void main(String[] args) {
        String str = "abedfdcba";
        // To convert str into `abe(c)dfdc(e)ba` need to insert c and e
        findNumberOfInsertionToLPS(str);
    }

}
