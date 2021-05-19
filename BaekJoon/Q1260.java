package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {    // DFS와 BFS
    static boolean[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first][second] = true;
            map[second][first] = true;
        }

        // dfs
        dfs(v);
        sb.append('\n');

        // bfs
        visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;

            visited[now] = true;
            sb.append(now).append(" ");

            for (int i = 0; i <= n; i++) {
                if (map[now][i]) {
                    queue.add(i);
                }
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int v) {
        if (visited[v]) return;

        visited[v] = true;
        sb.append(v).append(" ");
        for (int i = 0; i <= n; i++) {
            if (map[v][i]) {
                dfs(i);
            }
        }
    }
}
