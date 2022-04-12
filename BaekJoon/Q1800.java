package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1800 {    // 인터넷 설치
    static int n, k;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();

        int max = 0;
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            list[first].add(new int[]{second, value});
            list[second].add(new int[]{first, value});
            max = Math.max(max, value);
        }

        int min = 0, answer = -1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (dijkstra(mid)) {
                answer = mid;
                max = mid - 1;
            } else min = mid + 1;
        }

        System.out.println(answer);
    }

    static boolean dijkstra(int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int idx = now[0];
            int val = now[1];
            if (dist[idx] < val) continue;

            for (int[] next : list[idx]) {
                int nextIdx = next[0];
                int nextVal = val;
                if (next[1] > x) nextVal++;
                if (nextVal < dist[nextIdx]) {
                    dist[nextIdx] = nextVal;
                    pq.add(new int[]{nextIdx, nextVal});
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
