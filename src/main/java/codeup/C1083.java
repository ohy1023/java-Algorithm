package codeup;

import java.util.Scanner;

public class C1083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        for (int i = 1; i <= nextInt; i++) {
            if (i % 3 == 0) {
                System.out.print("X ");
            } else {

                System.out.print(i + " ");
            }
        }

    }
}
