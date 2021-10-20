package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1475 {    // 방 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            int now = n.charAt(i) - '0';
            if (now == 9) now = 6;

            if (map.containsKey(now)) {
                map.put(now, map.get(now) + 1);
            } else {
                map.put(now, 1);
            }
        }

        int answer = 0;
        for (int key : map.keySet()) {
            if (key == 6) {
                answer = Math.max(answer, map.get(key) / 2 + map.get(key) % 2);
            } else {
                answer = Math.max(answer, map.get(key));
            }
        }

        System.out.println(answer);
    }
}
