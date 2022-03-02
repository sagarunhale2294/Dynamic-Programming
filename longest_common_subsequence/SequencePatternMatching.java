package longest_common_subsequence;

public class SequencePatternMatching {
    static int t[][] = new int[100][100];

    private static int LCS(char x[], char y[], int m, int n) {
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

    private static void findGivenStringIsSubsequenceOfAnother(String s1, String s2) {
        // find if s1 is subsequence of s2 string
        int lcs = LCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        if (lcs == Math.min(s1.length(), s2.length())) {
            System.out.println("String `" + s1 + "` is sub-sequence of another string `" + s2 + "`");
        } else {
            System.out.println("String `" + s1 + "` is not a sub-sequence of another string `" + s2 + "`");
        }
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "abedc";
        findGivenStringIsSubsequenceOfAnother(s1, s2);
    }
}
