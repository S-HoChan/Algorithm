package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {    // 팰린드롬 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'A']++;
        }

        char mid = '-';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;

            char now = (char) ('A' + i);
            if (count[i] % 2 == 0) {
                for (int j = 0; j < count[i] / 2; j++)
                    sb.append(now);
            } else {
                if (mid != '-') {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else {
                    mid = now;
                    for (int j = 0; j < count[i] / 2; j++)
                        sb.append(now);
                }
            }
        }
        String answer = sb.toString();
        if (mid != '-') answer += mid;
        answer += sb.reverse().toString();
        System.out.println(answer);
    }
}
