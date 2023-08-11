package likelion.java1027;

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
        List<Player> lists = new ArrayList<>();
        for (String p : participant) {
            lists.add(new Player(p.hashCode(),p));
            sum += p.hashCode();
        }
        for (String c : completion) {
            sum -= c.hashCode();
        }
        for (Player player : lists) {
            if (player.getKey() == sum) {
                return player.getValue();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        HashPlayer hp = new HashPlayer();
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(hp.solution(participant,completion));
    }
}
