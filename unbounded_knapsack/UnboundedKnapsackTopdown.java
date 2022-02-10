package unbounded_knapsack;

public class UnboundedKnapsackTopdown {
	static int t[][] = new int[100][100];
	public static int knapsack(int wt[], int val[], int n, int w) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<w+1; j++) {
				if(i==0 || j==0){
					t[i][j] = 0;
				} else {
					if(wt[i-1] <= j){
						t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]], t[i-1][j]);
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][w];
	}
	
	public static void main(String[] args) {
		int wt[] = {2,3,4,5};
		int val[] = {1,4,5,2};
		int capacity = 10;
		System.out.println("Max profit: " + UnboundedKnapsackTopdown.knapsack(wt, val, 4, capacity));
	}

}
