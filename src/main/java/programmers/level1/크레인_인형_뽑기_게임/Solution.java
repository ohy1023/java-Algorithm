package programmers.level1.크레인_인형_뽑기_게임;

import java.util.Stack;

/**
 * 프로그래머스 크레인 인형 뽑기 게임 (level.2) - 스택
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java
 */
public class Solution {
    public int check(Stack<Integer> stack) {
        int cnt = 0;
        if (stack.size() >= 2) {
            if (stack.get(stack.size() - 1) == stack.get(stack.size() - 2)) {
                stack.pop();
                stack.pop();
                cnt += 2;
                cnt += check(stack);
            }
        }
        return cnt;
    }

    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    stack.push(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    result += check(stack);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        Solution c = new Solution();

        System.out.println(c.solution(board, moves));
    }
}
