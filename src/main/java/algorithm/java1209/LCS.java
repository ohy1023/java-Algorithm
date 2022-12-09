package algorithm.java1209;

public class LCS {
    public static void main(String[] args) {
        String str1 = "ABCDCBA"; // -> j로 놓고 안쪽에서 반복 ( 열 )
        String str2 = "DCABDC"; // -> ㅑ로 놓고 바깥쪽에서 반복 ( 행 )


        int[][] dp = new int[str2.length()][str1.length()];

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                System.out.printf("i : %s j : %s \n", str2.charAt(i), str1.charAt(j));
            }
        }
    }
}
