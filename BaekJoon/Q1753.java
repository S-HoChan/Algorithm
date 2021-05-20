package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {    // 최단경로
    private static final int INF = 20000 * 10 + 1;
    static int v, e;
    static List<List<Node>> list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;

        list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        dist = new int[v];
        Arrays.fill(dist, INF);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;   // num to idx
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, w));
        }

        StringBuilder sb = new StringBuilder();

        dijk(start);

        for (int i = 0; i < v; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.end]) continue;
            visited[current.end] = true;

            for (Node node : list.get(current.end)) {
                if (dist[node.end] > dist[current.end] + node.weight) {
                    dist[node.end] = dist[current.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
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
