package algorithm.java1123;

import java.util.ArrayList;
import java.util.List;

public class FibonacciAvatarByList {

    public int fib(int n) {
        if(n == 1 || n == 2) return 1;

        List<Integer> fibonacciNums = new ArrayList<>();
        fibonacciNums.add(1);
        fibonacciNums.add(1);
        for (int j = 2; j < n; j++) {
            fibonacciNums.add(fibonacciNums.get(j - 1) + fibonacciNums.get(j - 2));
        }

        return fibonacciNums.get(n - 1);
    }
    public static void main(String[] args) {

        FibonacciAvatarByList fabl = new FibonacciAvatarByList();
        System.out.println(fabl.fib(46));
    }
}
