package codeup;

import java.util.Scanner;

public class C1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
}

