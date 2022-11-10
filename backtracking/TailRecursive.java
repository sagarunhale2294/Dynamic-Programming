package backtracking;

public class TailRecursive {
    public static void main(String[] args) {
        int n=5;
        int factorial = factorial(n);
        System.out.println(factorial);
    }

    private static int factorial(int n) {
        return factorialInt(n, 1);
    }

    private static int factorialInt(int n, int a) {
        if(n<=1) 
            return a;
        return factorialInt(n-1, a * n);
    }
}
