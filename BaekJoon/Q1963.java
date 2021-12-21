package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1963 {    // 소수 경로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[10000];
        for (int i = 2; i < 10000; i++) {
            if (!visited[i]) {
                for (int j = i + i; j < 10000; j += i) {
                    visited[j] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            LinkedList<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            map.put(start, 0);
            queue.add(start);
            boolean flag = false;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                int move = map.get(now);
                if (now == end) {
                    sb.append(move).append('\n');
                    flag = true;
                    break;
                }

                int[] nowNum = {now / 1000, (now / 100) % 10, (now / 10) % 10, now % 10};
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        if (i == 0 && j == 0) continue;

                        int temp = nowNum[i];
                        nowNum[i] = j;
                        int next = toNumber(nowNum);
                        nowNum[i] = temp;

                        if (!visited[next] && !map.containsKey(next)) {
                            queue.add(next);
                            map.put(next, move + 1);
                        }
                    }
                }
            }
            if (!flag) sb.append("Impossible").append('\n');
        }
        System.out.println(sb);
    }

    static int toNumber(int[] nowNum) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            num += nowNum[i] * Math.pow(10, 3 - i);
        }
        return num;
    }
}
