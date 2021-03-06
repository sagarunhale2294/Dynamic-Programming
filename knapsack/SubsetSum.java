package knapsack;

public class SubsetSum {
	static boolean[][] t = new boolean[6][12];
	public static boolean findSubsetSum(int arr[], int sum, int n) {
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0) {
					t[i][j]= false;
				}
				if(j==0) {
					t[i][j] = true;
				} 
				if(i!=0 && j!=0){
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
	
	public static void main(String[] args) {
		int arr[] = {2,3,6,8,10};
		System.out.println(SubsetSum.findSubsetSum(arr, 11, 5) ? "Subset is present": "No subset present");
	}

}
