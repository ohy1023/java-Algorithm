package likelion.java1122;

import java.util.Scanner;

public class RecursionSum {
    public static int sum(int num, int res) {
        if (num == 0) {
            return res;
        }
        res += num;
        return sum(num - 1, res);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 0;
        System.out.println(sum(num, res));
    }
}
