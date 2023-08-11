package likelion.java1118;

public class CaesarCipher {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += c;
            } else {
                if (c >= 'a') {
                    if (c + n > 'z') {
                        c = (char) ('a' + (c + (n - 1) - 122));
                        answer += (char) (c);
                    } else {
                        answer += (char) (c + n);
                    }
                } else if (c >= 'A') {
                    if (c + n > 'Z') {
                        c = (char) ('A' + (c + (n - 1) - 90));
                        answer += (char) (c);
                    } else {
                        answer += (char) (c + n);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();
        String s = "a B z";
        int n = 4;
        System.out.println(cc.solution(s, n));
    }
}
