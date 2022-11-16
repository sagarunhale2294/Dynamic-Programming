package graph;

public class FindTownJudge {

    public static void main(String[] args) {
        // You have given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
        // e.g 1->3<-2
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        int output = findJudge(n, trust);
        System.out.println(output == -1 ? "No town judge found" : "Here Town judge is: " + output);
    }

    private static int findJudge(int n, int[][] trust) {
        int degrees[] = new int[n];
        for(int[] a: trust) {
            degrees[a[0]-1] = degrees[a[0]-1] - 1;
            degrees[a[1]-1] = degrees[a[1]-1] + 1;
        }
        for(int i=0; i<n; i++) {
            if(degrees[i]==(n-1)) {
                return i + 1;
            }
        }
        return -1;
    }
}
