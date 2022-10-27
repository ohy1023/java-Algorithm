package algorithm.java1027;

import java.util.HashMap;
import java.util.Map;

public class BRacer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String key = participant[i];
            memo.put(key, memo.getOrDefault(key, 0) + 1); // 중복처리
        }
        for (int i = 0; i < completion.length; i++) {
            String key = completion[i];
            memo.put(key, memo.get(key) - 1);
        }
        for (String key : memo.keySet()) {

            if (memo.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

}
