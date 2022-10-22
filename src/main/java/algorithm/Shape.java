package algorithm;

import java.util.Scanner;

public class Shape {
    public void printSquare(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printSquareV2(int x) {
        for (int i = 1; i <= x; i++) {
            if (i == 1 || i == x) {
                System.out.println("*".repeat(x));
            } else {
                System.out.println("*" + " ".repeat(x-2) + "*");
            }
        }
    }

    public void printRectangle(int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printParallelogram(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = x-i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < x; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape shape = new Shape();

        int size = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        
        System.out.println("정사각형");
        shape.printSquare(size);

        System.out.println("가운데 구멍난 정사각형");
        shape.printSquareV2(size);

        System.out.println("직사각형");
        shape.printRectangle(x,y);

        System.out.println("평행사변형");
        shape.printParallelogram(size);

    }
}

