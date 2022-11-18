package algorithm.java1118;

public class CaesarCipherTeacherVersion {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
                int theta = 65;
                if ((int) s.charAt(i) >= 97) {
                    theta = 97;
                }
                int r = ((int) s.charAt(i) - theta + n ) % 26;
                sb.append((char)(theta + r));
            } else {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CaesarCipherTeacherVersion cc = new CaesarCipherTeacherVersion();
        String s = "a B z";
        int n = 4;
        System.out.println(cc.solution(s, n));
    }
}
