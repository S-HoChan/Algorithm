package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9370 {    // 미확인 도착지  // todo. 정확성테스트 실패
    private static List<List<Node>> list;
    private static boolean[] visited;
    private static int[] dist;
    private static final int INF = 50000 * 1000 + 1;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int _t = 0; _t < t; _t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            visited = new boolean[n + 1];
            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 출발지
            int g = Integer.parseInt(st.nextToken());   // 포함경로1
            int h = Integer.parseInt(st.nextToken());   // 포함경로 2

            for (int i = 0; i < m; i++) {   // a와 b 사이의 d 길이의 양방향 도로
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if (a == g && b == h || a == h && b == g) {
                    list.get(a).add(new Node(b, d * 2 - 1));
                    list.get(b).add(new Node(a, d * 2 - 1));
                } else {
                    list.get(a).add(new Node(b, d * 2));
                    list.get(b).add(new Node(a, d * 2));
                }
            }

            ArrayList<Integer> candidate = new ArrayList<>();
            for (int i = 0; i < p; i++) {  // 목적지 후보
                candidate.add(Integer.parseInt(br.readLine()));
            }

            dijk(s);

            Collections.sort(candidate);
            for (int cand : candidate)
                if (dist[cand] % 2 == 1) sb.append(cand).append(' ');

            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) continue;
            visited[now.end] = true;

            for (Node node : list.get(now.end)) {
                if (!visited[node.end] && dist[node.end] > dist[now.end] + node.weight) {
                    dist[node.end] = dist[now.end] + node.weight;
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
