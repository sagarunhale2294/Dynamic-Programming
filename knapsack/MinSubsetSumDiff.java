package knapsack;

public class MinSubsetSumDiff {
	static boolean t[][] = new boolean[100][100];
	public static boolean isSubsetSum(int arr[], int sum, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0)
					t[i][j] = false;
				if(j==0)
					t[i][j] = true;
				if(i!=0 && j!=0) {
					if(arr[i-1]<=j) {
						t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][sum];
	}
	
	public static int findMinSubsetSumDiff(int arr[], int n) {
		int range = 0;
		int min = Integer.MAX_VALUE;
		for(int a: arr) {
			range = range+a;
		}
		// find min sum for range/2 elements
		for(int i=0; i<=range/2;i++){
			if(MinSubsetSumDiff.isSubsetSum(arr, i, n) == true) {
				min = Math.min(min, (range-2*i));
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = {1,3,7,9,2};
		System.out.println("Min Subset Sum Difference is: " + MinSubsetSumDiff.findMinSubsetSumDiff(arr,4));

	}

}
