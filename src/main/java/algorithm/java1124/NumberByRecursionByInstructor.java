package algorithm.java1124;

import java.util.Scanner;

public class NumberByRecursionByInstructor {

    private void printRow(int n) {
        if (n == 0) {
            return;
        }
        printRow(n - 1);
        System.out.print(n + " ");
    }

    private void printNums(int n) {
        if (n == 0) {
            return;
        }
        printNums(n - 1);
        printRow(n);
        System.out.println();
    }

    public static void main(String[] args) {
        NumberByRecursionByInstructor number = new NumberByRecursionByInstructor();
        Scanner sc = new Scanner(System.in);
        number.printNums(sc.nextInt());
    }
}
