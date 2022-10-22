package codeup;

import java.util.Scanner;

public class C1069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        Character ch = a.charAt(0);
        if (ch == 'A') {
            System.out.println("best!!!");
        } else if (ch == 'B') {
            System.out.println("good!!!");
        } else if (ch == 'C') {
            System.out.println("run!");
        } else if (ch == 'D') {
            System.out.println("slowly~");
        } else {
            System.out.println("what?");
        }
    }
}
