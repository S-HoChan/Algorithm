package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q10546 {   // 배부른 마라토너
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else map.put(name, 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            if (map.get(name) == 1) map.remove(name);
            else map.put(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            System.out.println(name);
        }
    }
}
