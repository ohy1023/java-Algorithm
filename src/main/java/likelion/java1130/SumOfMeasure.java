package likelion.java1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfMeasure {
    public int solution(int num) {
        int answer = 0;
        for (int i = 1; i <= Math.floorDiv(num,2); i++) {
            if (Math.floorMod(num, i) == 0) {
                answer += i;
            }
        }
        return answer + num;
    }

    public static void main(String[] args) throws IOException {
        SumOfMeasure sum = new SumOfMeasure();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(sum.solution(num));
    }
}
