package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1966 {    // 프린터 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int _t = 0; _t < t; _t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (now[1] < queue.get(i)[1]) {
                        queue.add(now);
                        for (int j = 0; j < i; j++) {
                            queue.add(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) continue;

                cnt++;
                if (now[0] == m) break;
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}