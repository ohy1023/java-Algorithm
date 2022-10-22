package codeup;

import java.util.Scanner;

public class C1095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = 2147000000;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);

    }
}
