package knapsack;

public class CountOfSubsetSum {
	static int t[][] = new int[5][11];
	public static int countOfSubsetSum(int[] arr, int sum, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0) {
					t[i][j] = 0;
				}
				if(j==0) {
					t[i][j] = 1;
				}
				if(i!=0 && j!=0) {
					if(arr[i-1] <= j) {
						t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		int arr[] = {2,6,8,10};
		System.out.println("Count of subset sum: " + CountOfSubsetSum.countOfSubsetSum(arr, 10, 4));

	}

}
