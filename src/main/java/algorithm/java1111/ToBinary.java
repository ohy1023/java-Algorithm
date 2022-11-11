package algorithm.java1111;

public class ToBinary {
    public static void main(String[] args) {
        int num = 0;
        String ans = "";
        while (num > 0) {
            String res = String.valueOf(num % 2);
            num /= 2;
            ans += res;
        }
        String reverse = "";
        for (int i = ans.length() - 1; i >= 0; i--) {
            reverse += ans.charAt(i);
        }
        System.out.println(reverse);

    }
}
