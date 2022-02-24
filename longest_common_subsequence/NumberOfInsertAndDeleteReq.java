package longest_common_subsequence;

public class NumberOfInsertAndDeleteReq {
    // find the number of insertion and deletion requred to convert one string to
    // another

    static int t[][] = new int[100][100];

    private static int findLCS(char x[], char y[], int m, int n) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else {
                    if (x[i - 1] == y[j - 1]) {
                        t[i][j] = 1 + t[i - 1][j - 1];
                    } else {
                        t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                    }
                }
            }
        }
        return t[m][n];
    }

    private static void findNumberOfInsertionAndDeletionRequired(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int lcs = findLCS(s1.toCharArray(), s2.toCharArray(), m, n);
        System.out.println("Number of Insertion = " + (n - lcs) + " and deletion = " + (m - lcs));
    }

    public static void main(String[] args) {
        String s1 = "peaks", s2 = "heap";
        findNumberOfInsertionAndDeletionRequired(s1, s2);
    }
}