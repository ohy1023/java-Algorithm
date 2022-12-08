package algorithm.java1208;

public class FibonacciByDP {
    private long findFibonacci(int n) {
        long[] memo = new long[n + 1];
        memo[0] = 1;
        if (n > 0) {
            memo[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            System.out.println("dfds");
        }
        return memo[n];
    }

    public static void main(String[] args) {
        FibonacciByDP dp = new FibonacciByDP();
        System.out.println(dp.findFibonacci(1));
    }
}
