package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20437 {   // 문자열 게임 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append("1 1").append('\n');
                continue;
            }

            int[] alphabet = new int[26];   // 알파벳 개수
            for (int i = 0; i < w.length; i++) {
                alphabet[w[i] - 'a']++;
            }

            int min = w.length + 1; // 조건 3
            int max = -1;   // 조건 4
            for (int i = 0; i < w.length; i++) {
                if (alphabet[w[i] - 'a'] < k) continue;
                int cnt = 1;
                for (int j = i + 1; j < w.length; j++) {
                    if (w[i] == w[j]) cnt++;
                    if (cnt == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            if (min == w.length + 1) sb.append(-1).append('\n');
            else sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }
}
