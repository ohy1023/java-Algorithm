package codeup;

import java.util.Scanner;

public class C1096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[19][19];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x-1][y-1] = 1;
        }

        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }
}
