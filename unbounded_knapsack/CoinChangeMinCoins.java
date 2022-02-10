package unbounded_knapsack;

public class CoinChangeMinCoins {
	static int t[][] = new int[100][100];
	private static int minNoOfCoins(int coins[], int sum, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(j==0) t[i][j] = 0;
				if(i==0) t[i][j] = Integer.MAX_VALUE-1;
				if(i==1) {
					if(j% coins[i] == 0) {
						t[i][j] = j/coins[i]; 
					} else {
						t[i][j] = Integer.MAX_VALUE-1;
					}
				} 
				if(i!=0 && i!=1 && j!=0) {
					if(coins[i-1] <= j) {
						t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]);
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][sum];
	}
	
	public static void main(String[] args) {
		int coins[] = {1,2,3};
		int sum = 5;
		System.out.println("Min number of coins: " + minNoOfCoins(coins, sum, 3));
	}
}
