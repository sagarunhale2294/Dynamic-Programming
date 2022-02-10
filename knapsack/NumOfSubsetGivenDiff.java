package knapsack;

public class NumOfSubsetGivenDiff {
	static int t[][] = new int[100][100];
	private static int findSubsetSumGivenDiff(int[] arr, int diff) {
		int sum = (diff + findTotalSumArry(arr))/2;
		return countSubsetSum(arr, arr.length, sum);
		
	}
	
	private static int countSubsetSum(int[] arr, int n, int sum) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0) t[i][j] = 0;
				if(j==0) t[i][j] = 1;
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

	private static int findTotalSumArry(int[] arr) {
		int totalSum = 0;
		for(int a: arr) {
			totalSum = totalSum + a;
		}
		return totalSum;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,1};
		int diff = 1;
		System.out.println("Number of subsets with given difference: " + NumOfSubsetGivenDiff.findSubsetSumGivenDiff(arr, diff));
	}

}
