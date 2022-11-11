package algorithm.java1111;

public class ToBinary {
    public static void main(String[] args) {
        int num = 12;
        while (num > 0) {
            String res = String.valueOf(num % 2);
            num /= 2;

        }

    }
}
