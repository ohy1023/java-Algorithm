package programmers.level3.sol42579;

import java.util.*;

/**
 * 프로그래머스 Level.3 베스트앨범 - 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java
 */
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> genreTotalPlays = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> genreIndividualPlays = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Integer play = plays[i];


            genreIndividualPlays.putIfAbsent(genre, new HashMap<>());
            genreIndividualPlays.get(genre).put(i, play);
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);
        }

        ArrayList<String> ketSet = new ArrayList<>(genreTotalPlays.keySet());
        Collections.sort(ketSet, (o1, o2) -> Integer.compare(genreTotalPlays.get(o2), genreTotalPlays.get(o1)));

        for (String key : ketSet) {
            HashMap<Integer, Integer> map = genreIndividualPlays.get(key);
            ArrayList<Integer> genreKey = new ArrayList<>(map.keySet());

            Collections.sort(genreKey, (o1, o2) -> map.get(o2) - map.get(o1));

            answer.add(genreKey.get(0));
            if (genreKey.size() > 1) {
                answer.add(genreKey.get(1));
            }

        }

        for (Integer i : answer) {
            System.out.print(i + " ");
        }

        return answer.stream().mapToInt(i ->i).toArray();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i : s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})) {
            System.out.print(i + " ");
        }
    }
}

