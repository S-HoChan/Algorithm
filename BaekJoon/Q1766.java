package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n];
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + 1).append(" ");
            for (int next : list[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
