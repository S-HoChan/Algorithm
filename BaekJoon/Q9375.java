package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q9375 {    // 패션왕 신해빈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int _t = 0; _t < t; _t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] now = br.readLine().split(" ");
                if (map.containsKey(now[1]))
                    map.put(now[1], map.get(now[1]) + 1);
                else
                    map.put(now[1], 1);
            }

            int ans = 1;
            for(int val : map.values())
                ans *= (val + 1);

            sb.append(ans - 1).append('\n');
        }

        System.out.println(sb);
    }
}
