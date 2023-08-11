package likelion;

import java.util.Scanner;

public class Pyramid {
    public void printStar(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = N - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pyramid pyramid = new Pyramid();
        pyramid.printStar(N);

    }


}
