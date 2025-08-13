package book.thisiscodingtest.Implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열_재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        List<Character> characters = new ArrayList<>();

        int sum = 0;
        boolean hasDigit = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (Character.isDigit(c)) {
                sum += c - '0';
                hasDigit = true;
            } else {
                characters.add(c);
            }
        }

        Collections.sort(characters);

        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        if (hasDigit) sb.append(sum);
        System.out.println(sb);
    }
}
