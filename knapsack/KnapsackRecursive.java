package knapsack;

public class KnapsackRecursive {
	
	public static int knapsack(int wt[], int val[], int w, int n) {
		if(n==0 || w==0) {
			return 0;
		}
		if(wt[n-1] <= w) {
			return Math.max(val[n-1] + knapsack(wt,val,w-wt[n-1],n-1), 
					knapsack(wt,val,w,n-1));
		} else {
			return knapsack(wt, val,w,n-1);
		}
	}

	public static void main(String[] args) {
		int wt[] = {1,2,3,4,5};
		int val[] = {6,9,4,2,8};
		int w = 10;
		System.out.println("Max Profit:" + knapsack(wt, val, w, 5));
	}
}
