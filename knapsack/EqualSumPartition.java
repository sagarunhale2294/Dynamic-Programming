package knapsack;

public class EqualSumPartition {
	static boolean t[][] = new boolean[5][100];
	public static boolean areEqualSumPartition(int arr[], int n) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = sum + arr[i];
		}
		if(sum%2!=0) {
			return false;
		}
		return isSubsetSum(arr, sum/2,n);
	}
	
	public static boolean isSubsetSum(int arr[], int sum, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0) {
					t[i][j] = false;
				}
				if(j==0) {
					t[i][j] = true;
				}
				if(i!=0 && j!=0) {
					if(arr[i-1] <= j) {
						t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		int arr[] = {2,5,12,5};
		System.out.println(EqualSumPartition.areEqualSumPartition(arr, 4)? "Equal sum partitions are present." : "Equal sum partitions are not present.");
	}
 
}
