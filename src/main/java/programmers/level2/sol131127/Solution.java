package programmers.level2.sol131127;

import java.util.*;

/**
 * 프로그래머스 Level.2 할인 행사 - 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++){
            String item = want[i];
            int count = number[i];
            
            wantMap.put(item, count);
        }
        
        for (int j = 0; j <= discount.length - 10; j++) {
            Map<String, Integer> cntMap = new HashMap<>();
            for (int k = j; k < j + 10; k++) {
                if (wantMap.getOrDefault(discount[k], -1) == -1) break;
                else if (wantMap.get(discount[k]) < cntMap.getOrDefault(discount[k], 0)) break;
                
                cntMap.put(discount[k], cntMap.getOrDefault(discount[k], 0) + 1);
            }
            
            boolean check = true;
            
            for(String key : wantMap.keySet()){
                if(wantMap.get(key) != cntMap.get(key)){
                    check = false;
                    break;
                }
            }
            
            answer += (check) ? 1 : 0;
        }
        
        return answer;
    }
}