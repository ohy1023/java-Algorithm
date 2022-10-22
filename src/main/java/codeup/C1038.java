package codeup;

import java.util.Scanner;

public class C1038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        Long sum = 0l;
        String[] split = st.split(" ");
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}
