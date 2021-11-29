package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1302 {    // 베스트셀러
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String now = br.readLine();
            if (map.containsKey(now)) {
                map.put(now, map.get(now) + 1);
            } else {
                map.put(now, 1);
            }
        }

        String answer = "";
        int max = 0;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if ((max == value && answer.compareTo(key) > 0) || max < value) {
                answer = key;
                max = value;
            }
        }
        System.out.println(answer);
    }
}
