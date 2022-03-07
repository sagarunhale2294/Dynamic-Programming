package matrix_chain_multiplication;

public class MCMRecursive {

    private static int solve(int arr[], int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 30 };
        System.out.println(solve(arr, 1, arr.length - 1));
    }
}
