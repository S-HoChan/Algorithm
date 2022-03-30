package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q9324 {    // 진짜 메시지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            boolean isOk = true;
            Map<Character, Integer> map = new HashMap<>();
            char[] arr = br.readLine().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char now = arr[i];
                if (map.containsKey(now)) {
                    if (map.get(now) < 2)
                        map.put(now, map.get(now) + 1);
                    else if (i == arr.length - 1 || arr[i + 1] != now) {
                        isOk = false;
                        break;
                    } else {
                        map.remove(now);
                        i++;
                    }
                } else map.put(now, 1);
            }
            sb.append(isOk ? "OK" : "FAKE").append('\n');
        }
        System.out.println(sb);
    }
}
