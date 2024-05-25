package programmers.level2.과제_진행하기;

import java.util.*;

/**
 * 프로그래머스 level 2 과제 진행하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */
class Solution {

    static class Assignment implements Comparable<Assignment> {
        String name;
        int startTime;
        int usageTime;

        public Assignment(String name, int startTime, int usageTime) {
            this.name = name;
            this.startTime = startTime;
            this.usageTime = usageTime;
        }

        public Assignment(String name, int usageTime) {
            this.name = name;
            this.usageTime = usageTime;
        }

        @Override
        public int compareTo(Assignment o) {
            return Integer.compare(this.startTime, o.startTime);
        }

    }

    /**
     * 주어진 과제 계획에 따라 진행해야 하는 과제의 이름 목록을 반환하는 메서드
     * @param plans 각 과제의 정보가 담긴 2차원 배열
     * @return 과제의 이름 목록
     */
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        PriorityQueue<Assignment> pq = new PriorityQueue<>();

        // 각 과제의 시작 시간과 소요 시간을 계산하여 우선순위 큐에 저장
        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            int hours = Integer.parseInt(split[0]);
            int minutes = Integer.parseInt(split[1]);
            int startTime = hours * 60 + minutes; // 시작 시간을 분 단위로 변환
            int usageTime = Integer.parseInt(plan[2]);

            pq.offer(new Assignment(plan[0], startTime, usageTime));
        }

        Stack<Assignment> restAssignment = new Stack<>();

        while (!pq.isEmpty()) {
            Assignment curAssignment = pq.poll();

            String curName = curAssignment.name;
            int curStartTime = curAssignment.startTime;
            int curUsageTime = curAssignment.usageTime;

            if (!pq.isEmpty()) {
                Assignment nextAssignment = pq.peek();

                // 현재 과제의 종료 시간과 다음 과제의 시작 시간을 비교하여 과제를 진행할지 여부 결정
                if (curStartTime + curUsageTime > nextAssignment.startTime) {
                    restAssignment.push(new Assignment(curName, curUsageTime - (nextAssignment.startTime - curStartTime)));
                } else if (curStartTime + curUsageTime == nextAssignment.startTime) {
                    answer.add(curName);
                } else {
                    answer.add(curName);
                    curStartTime += curUsageTime;
                    // 이전에 중단된 과제가 있는지 확인하여 계속 진행
                    while (!restAssignment.isEmpty()) {
                        Assignment prevAssignment = restAssignment.pop();

                        int prevUsageTime = prevAssignment.usageTime;

                        if (curStartTime + prevUsageTime > nextAssignment.startTime) {
                            restAssignment.push(new Assignment(prevAssignment.name, prevUsageTime - (nextAssignment.startTime - curStartTime)));
                            break;
                        } else {
                            answer.add(prevAssignment.name);
                            curStartTime += prevUsageTime;
                        }
                    }
                }
            } else {
                // 마지막 과제까지 진행된 경우 남은 과제들을 모두 진행
                answer.add(curName);
                while (!restAssignment.isEmpty()) {
                    Assignment restAssignmentItem = restAssignment.pop();
                    answer.add(restAssignmentItem.name);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> result = s.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});

        // 결과 출력
        for (String r : result) {
            System.out.println(r);
        }
    }
}
