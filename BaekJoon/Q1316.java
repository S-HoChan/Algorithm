package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1316 {    // 그룹 단어 체커
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            String word = br.readLine();
            if(word.length() == 1) {
                answer++;
                continue;
            }

            List<Character> list = new ArrayList<>();
            list.add(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                char now = word.charAt(i);

                if (now != word.charAt(i - 1)) {
                    if (list.contains(now)) {
                        break;
                    } else list.add(now);
                }

                if (i == word.length() - 1) answer++;
            }
        }

        System.out.println(answer);
    }
}
