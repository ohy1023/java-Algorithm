package codeup;

import java.util.Scanner;

public class C1080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
            if (sum >= num) {
                System.out.println(i);
                break;
            }
        }
    }
}
