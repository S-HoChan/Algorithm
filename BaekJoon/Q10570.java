package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q10570 {   // Favorite Number
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int v = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            while (v-- > 0) {
                int s = Integer.parseInt(br.readLine());
                if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }
            int answer = 0;
            int maxCnt = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > maxCnt) {
                    answer = key;
                    maxCnt = map.get(key);
                } else if (map.get(key) == maxCnt) {
                    answer = Math.min(answer, key);
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
