package codeup;

import java.util.Scanner;

public class C1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] arr = new int[h][w];

        int n = sc.nextInt();

        for (int j = 0; j < n; j++) {
            int i = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;


            for (int k = 0; k < i; k++) {
                arr[x][y] = 1;
                if (d == 0) {
                    y++;
                } else {
                    x++;
                }

            }
        }

        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[j][k]+ " ");
            }
            System.out.println();
        }
    }
}
