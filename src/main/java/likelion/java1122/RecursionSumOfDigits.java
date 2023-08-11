package likelion.java1122;

import java.util.Scanner;

public class RecursionSumOfDigits {
    public static long sumOfDigits(long num) {
        if (num == 0) {
            return 0;
        }
        long res = num % 10;
        num /= 10;

        return  res +sumOfDigits(num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        System.out.println(sumOfDigits(num));
    }
}
