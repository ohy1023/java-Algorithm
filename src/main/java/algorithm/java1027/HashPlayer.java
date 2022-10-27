package algorithm.java1027;

import java.util.ArrayList;
import java.util.List;

public class HashPlayer {
    class Player {
        private Integer key;
        private String value;

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Player(Integer key, String value) {
            this.key = key;
            this.value = value;


        }
    }
    public String solution(String[] participant, String[] completion) {
        int sum = 0;
        String answer = "";
        List<Player>[] lists = new ArrayList[10];
        for (String p : participant) {
            if (lists[0] == null) {
                lists[0] = new ArrayList<>();
            }
            lists[0].add(new Player(p.hashCode(),p));
            sum += p.hashCode();
        }
        for (String c : completion) {
            sum -= c.hashCode();
        }
        System.out.println(sum);
        return answer;
    }

    public static void main(String[] args) {
        HashPlayer hp = new HashPlayer();
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(hp.solution(participant,completion));
    }
}
