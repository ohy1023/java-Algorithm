package codeup;

import java.util.Scanner;

public class C1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] units = new int[]{10000, 1000, 100, 10, 1};
        for (int u : units) {
            System.out.println("[" + num / u * u + "]");
            num %= u;
        }
    }
}
