package codeup;

import java.util.Scanner;

public class C1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character ch = sc.nextLine().charAt(0);
        Character c = 'a';
        while (c <= ch)
            System.out.println(c++);
    }
}

