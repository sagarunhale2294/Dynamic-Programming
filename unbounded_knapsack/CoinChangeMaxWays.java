package unbounded_knapsack;

public class CoinChangeMaxWays {
	static int t[][] = new int[100][100];
	private static int maxWays(int coins[], int sum, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0) t[i][j] = 0;
				if(j==0) t[i][j] = 1;
				if(i!=0 && j!=0) {
					if(coins[i-1] <= j) {
						t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		// we have given number of coins and we hve to find number of ways to make sum of the coins as 5.
		int coins[] = {1,2,3};
		int sum = 5;
		System.out.println("Max number of ways: " + maxWays(coins, sum, 3));
	}

}
