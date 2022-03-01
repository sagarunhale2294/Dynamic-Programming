package longest_common_subsequence;

public class PrintShortestCommonSuperSequence {
    static int t[][] = new int[100][100];

    private static void LCS(char x[], char y[], int m, int n) {
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
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
    }

    private static void printShortestCommonSuperSequence(char x[], char y[], int m, int n) {
        int i = m, j = n;
        StringBuffer stringBuffer = new StringBuffer();
        LCS(x, y, x.length, y.length);
        while(i > 0 && j > 0) {
            if(x[i-1] == y[j-1]) {
                stringBuffer.append(x[i-1]);
                i--;
                j--;
            } else {
                if(t[i-1][j] > t[i][j-1]) {
                    stringBuffer.append(x[i-1]);
                    i--;
                } else {
                    stringBuffer.append(y[j-1]);
                    j--;
                }
            }
        }

        while (i > 0) {
            stringBuffer.append(x[i-1]);
            i--;
        }
        while(j > 0) {
            stringBuffer.append(y[j-1]);
            j--;
        }

        System.out.println("Shortest common super sequence is: " + stringBuffer.reverse().toString());
    }

    public static void main(String[] args) {
        String s1 = "geek", s2 = "eke";
        printShortestCommonSuperSequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }
}
