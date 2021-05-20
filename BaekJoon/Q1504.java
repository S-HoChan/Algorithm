package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {    // 특정한 최단 경로
    private static List<List<Node>> list;
    private static int[] dist;
    private static boolean[] visited;
    private static final int INF = 800 * 200000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        int e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = dijk(1, v1) + dijk(v1, v2) + dijk(v2, n);
        int res2 = dijk(1, v2) + dijk(v2, v1) + dijk(v1, n);

        if (res1 >= INF && res2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(res1, res2));
    }

    private static int dijk(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) continue;
            visited[now.end] = true;

            for (int i = 0; i < list.get(now.end).size(); i++) {
                Node next = list.get(now.end).get(i);
                if (!visited[next.end] && dist[next.end] > now.weight + next.weight) {
                    dist[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
