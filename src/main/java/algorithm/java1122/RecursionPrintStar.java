package algorithm.java1122;

import java.util.Scanner;

public class RecursionPrintStar {
    public static void printStar(int n) {
        if (n == 0) {
            return;
        }
        System.out.print("*");
        printStar(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        printStar(cnt);
    }
}
