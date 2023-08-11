package likelion.java1123;

import java.util.Scanner;

public class FibonacciSequence {
    public int solution(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return solution(num - 1) + solution(num - 2);
        }
    }

    public static void main(String[] args) {
        FibonacciSequence fs = new FibonacciSequence();
        Scanner sc = new Scanner(System.in);
        System.out.println(fs.solution(sc.nextInt()));
    }
}
