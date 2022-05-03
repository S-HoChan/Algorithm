package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2841 {    // 외계인의 기타 연주
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i, new PriorityQueue<>((o1, o2) -> o2 - o1));

        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (!map.get(key).contains(value)) {
                map.get(key).add(value);
                answer++;
            }
            while (map.get(key).peek() > value) {
                map.get(key).poll();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
