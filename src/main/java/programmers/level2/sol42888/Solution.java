package programmers.level2.sol42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 Level.2 오픈채팅방
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42888">...</a>
 */
class Solution {
    public String[] solution(String[] record) {

        Map<String, String> userMap = new HashMap<>();

        List<String> messages = new ArrayList<>();

        for (String r : record) {
            String[] command = r.split(" ");
            String action = command[0];
            String userId = command[1];

            if (action.equals("Enter") || action.equals("Change")) {
                String userName = command[2];
                userMap.put(userId, userName);
            }
        }

        for (String r : record) {
            String[] command = r.split(" ");
            String action = command[0];
            String userId = command[1];

            if (action.equals("Enter")) {
                messages.add(userMap.get(userId) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                messages.add(userMap.get(userId) + "님이 나갔습니다.");
            }
        }

        return messages.toArray(new String[0]);
    }


}
