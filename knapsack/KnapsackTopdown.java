package knapsack;

public class KnapsackTopdown {
	static int t[][] = new int[6][11];
	
	public static int knapsack(int wt[], int val[], int w, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<w+1; j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				} else {
					if(wt[i-1] <= j) {	
					t[i][j]= Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
					} else {
					t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][w];
	}

	public static void main(String[] args) {
		int wt[] = {1,2,3,4,5};
		int val[] = {6,9,4,2,8};
		int w = 10;
		System.out.println("Max Profit:" + knapsack(wt, val, w, 5));
	}
}
