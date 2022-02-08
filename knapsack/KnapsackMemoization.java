package knapsack;

public class KnapsackMemoization {
	static int t[][] = new int[6][11];
	public static int knapsack(int wt[], int val[], int w, int n) {
		if(n==0 || w==0) {
			return 0;
		}
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<w+1;j++) {
				t[i][j] = -1;
			}
		}
		if(t[n][w]!=-1) {
			return t[n][w];
		}
		if(wt[n-1] <= w) {
			t[n][w]=Math.max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1), knapsack(wt,val,w,n-1));
		} else {
			t[n][w]=knapsack(wt,val,w,n-1);
		}
		return t[n][w];
	}

	public static void main(String[] args) {
		int wt[] = {1,2,3,4,5};
		int val[] = {6,9,4,2,8};
		int w = 7;
		System.out.println("Max Profit:" + knapsack(wt, val, w, 5));
	}
}
