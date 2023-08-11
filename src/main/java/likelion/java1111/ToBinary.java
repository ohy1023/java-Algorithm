package likelion.java1111;

public class ToBinary {

    String getBinaryString(int n) {
        String answer = "";
        while (n > 0) {
            answer += n % 2;  // string + int = string
            n /= 2;
        }
        return answer;
    }
    public static void main(String[] args) {
        int num = 30;
        if (num == 0) {
            System.out.println(0);
        }
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
