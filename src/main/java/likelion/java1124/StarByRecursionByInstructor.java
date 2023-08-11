package likelion.java1124;

import java.util.Scanner;

public class StarByRecursionByInstructor {

    public void printStar(int n) {
        if (n == 0) {
            return;
        }
        System.out.print("*");
        printStar(n-1);
    }

    public void printRow(int n) {
        if (n == 0) {
            return;
        }
        printRow(n - 1);
        printStar(n);
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StarByRecursionByInstructor star = new StarByRecursionByInstructor();
        star.printRow(sc.nextInt());
    }
}
