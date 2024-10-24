package programmers.level1.sol340213;

/**
 * 프로그래머스 Level.1 동영상 재생기
 */
class Solution {

    // 주어진 입력을 기반으로 동영상 재생 시간과 명령어들을 처리하는 메서드
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 입력된 시간을 초 단위로 변환
        int videoLen = calcSecond(video_len);    // 동영상 전체 길이
        int curSecond = calcSecond(pos);         // 현재 재생 위치
        int opStartSecond = calcSecond(op_start); // 오프닝 시작 시간
        int opEndSecond = calcSecond(op_end);     // 오프닝 끝나는 시간

        // 현재 위치가 오프닝 구간이라면 오프닝 끝나는 지점으로 이동
        curSecond = toOp(curSecond, opStartSecond, opEndSecond);

        // 명령어들을 처리하는 반복문
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case ("next"): {  // 10초 앞으로 이동
                    curSecond += 10;
                    if (videoLen < curSecond) { // 동영상 길이를 넘어가면 마지막 지점으로 설정
                        curSecond = videoLen;
                    }
                    break;
                }

                case ("prev"): {  // 10초 뒤로 이동
                    curSecond -= 10;
                    if (curSecond < 0) {  // 0초 미만이면 0초로 설정
                        curSecond = 0;
                    }
                    break;
                }
            }

            // 명령어를 실행한 후에도 오프닝 구간이면 오프닝 끝나는 지점으로 이동
            curSecond = toOp(curSecond, opStartSecond, opEndSecond);
        }

        // 결과를 "분:초" 형식으로 변환 후 반환
        return calcTime(curSecond);
    }

    // 현재 시간이 오프닝 구간에 있는지 확인하여 오프닝 끝으로 이동시키는 메서드
    private static int toOp(int curSecond, int opStartSecond, int opEndSecond) {
        if (curSecond >= opStartSecond && curSecond <= opEndSecond) {
            curSecond = opEndSecond;
        }
        return curSecond;
    }

    // "분:초" 형식의 시간을 입력받아 초 단위로 변환하는 메서드
    public int calcSecond(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    // 초 단위의 시간을 "분:초" 형식의 문자열로 변환하는 메서드
    public String calcTime(int second) {
        StringBuilder sb = new StringBuilder();

        int minute = second / 60;  // 분 계산
        int restSecond = second % 60;  // 나머지 초 계산

        // 분이 10 미만일 경우 앞에 '0'을 붙임
        if (minute < 10) {
            sb.append(0);
        }
        sb.append(minute).append(":");

        // 초가 10 미만일 경우 앞에 '0'을 붙임
        if (restSecond < 10) {
            sb.append(0);
        }
        sb.append(restSecond);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 테스트 케이스 실행
        System.out.println(s.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
    }
}
