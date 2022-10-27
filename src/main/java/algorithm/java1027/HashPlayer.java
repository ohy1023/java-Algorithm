package algorithm.java1027;

import java.util.ArrayList;
import java.util.List;

public class HashPlayer {
    class Player {
        private Integer key;
        private String value;

        public Player(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public String solution(String[] participant, String[] completion) {
        int sum = 0;
        String answer = "";
        List<Player>[] lists = new ArrayList[100];
        for (String s : participant) {
            lists[s.hashCode()].add(new Player(s.hashCode(),s));
            sum += s.hashCode();
        }
        for (String s : completion) {

        }
        return answer;
    }

    public static void main(String[] args) {
        HashPlayer hp = new HashPlayer();

        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(hp.solution(participant,completion));
    }
}
