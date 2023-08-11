package likelion;

import java.util.Scanner;

public class RightTriangle {
    private String letter = "*";

    private int count;

    public RightTriangle() {
    }

    public RightTriangle(String letter) {
        this.letter = letter;

    }

    public void printStar(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        RightTriangle rightTriangle = new RightTriangle();
        rightTriangle.printStar(N);

    }


}
