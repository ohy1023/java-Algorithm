package inflearn.section_04.hashmap.모든_아나그램_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static String s, t;

    static HashMap<Character, Integer> baseline;

    static int solution(String a, String b) {
        int res = 0;
        for (int i = 0; i <= a.length() - b.length(); i++) {
            Map<Character, Integer> hashMap = new HashMap<>();
            String substring = a.substring(i, i + b.length());

            for (int j = 0; j < substring.length(); j++) {
                hashMap.put(substring.charAt(j), hashMap.getOrDefault(substring.charAt(j), 0) + 1);
            }

            if (baseline.equals(hashMap)) {
                res++;
            }
        }


        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        baseline = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            baseline.put(t.charAt(i), baseline.getOrDefault(t.charAt(i), 0) + 1);
        }

        System.out.println(solution(s, t));

    }
}
