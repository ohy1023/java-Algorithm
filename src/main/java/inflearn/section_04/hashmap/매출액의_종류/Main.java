package inflearn.section_04.hashmap.매출액의_종류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0) + 1);
            answer.add(hashMap.size());
            hashMap.put(arr[lt], hashMap.get(arr[lt]) - 1);
            if (hashMap.get(arr[lt]) == 0) {
                hashMap.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        for (int x : main.solution(n, m, arr)) {
            System.out.print(x + " ");
        }
    }
}
