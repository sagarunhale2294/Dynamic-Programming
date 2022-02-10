package unbounded_knapsack;

public class UnboundedKnapsackRecursive {
	public static int knapsack(int wt[], int val[], int n, int w) {
		if(n==0 || w==0) {
			return 0;
		}
		if(wt[n-1]<=w) {
			return Math.max(val[n-1] + knapsack(wt, val, n, w-wt[n-1]), knapsack(wt, val, n-1, w));
		} else {
			return knapsack(wt, val, n-1, w);
		}
	}

	public static void main(String[] args) {
		int wt[] = {2,3,4,5};
		int val[] = {1,4,5,2};
		int capacity = 10;
		System.out.println("Max profit: " + UnboundedKnapsackRecursive.knapsack(wt, val, 4, capacity));
	}
}
