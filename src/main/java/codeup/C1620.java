package codeup;

import java.util.Scanner;

public class C1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num = sc.nextInt();
        while (num/10 > 0) {
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        System.out.println(sum);
    }
}
