package algorithm.java1111;

import java.util.Arrays;

/**
 * 1. 각 배열의 인덱스 값을 기준으로 비트연산자 or로 10진수 추출
 * 2. 10진수 -> 2진수 변경
 * 3. 새로운 배열에 값을 담고
 * 4. 1이면 #으로, 0이면 공백으로 치환
 */
public class SecretMap {



    // 내 코드
    String[] solution(int n, int[] arr1, int[] arr2) {
        String[] binaryList = new String[n];
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];
            String binaryString = Integer.toBinaryString(num);
            binaryList[i] = binaryString;
        }

        return binaryList;
    }

    // 강사님 코드
    String getBinaryString(int decNum) {
        String answer = "";
        while (decNum > 0) {
            answer += decNum % 2;
            decNum /= 2;
        }
        return answer;
    }

    // 강사님 코드
    String solution2(int n, int[] arr1, int[] arr2) {
        String answer = "";
        String[] sArr1 = new String[n];
        String[] sArr2 = new String[n];
        for (int i = 0; i < n; i++) {
            // arr1
            for (int j = 0; j < n; j++) {
                String binStr1 = getBinaryString(arr1[i]);
                String binStr2 = getBinaryString(arr2[i]);
                sArr1[i] = "0".repeat(n - binStr1.length()) + binStr1;
                sArr2[i] = "0".repeat(n - binStr2.length()) + getBinaryString(arr2[i]);
            }
        }
        System.out.println(Arrays.toString(sArr1));
        System.out.println(Arrays.toString(sArr2));

        return answer;

    }

    public static void main(String[] args) {
        SecretMap sm = new SecretMap();
        String[] solution = sm.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        System.out.println(Arrays.toString(solution));

    }
}
