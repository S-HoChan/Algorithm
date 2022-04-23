package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q18126 {   // 너구리 구구
    static List<int[]>[] list;
    static long answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        list = new ArrayList[n];    // 연결된 노드, 거리
        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new int[]{to, dist});
            list[to].add(new int[]{from, dist});
        }

        visited[0] = true;
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int now, long dist) {
        answer = Math.max(answer, dist);
        for (int[] next : list[now]) {
            if (visited[next[0]]) continue;
            visited[next[0]] = true;
            dfs(next[0], dist + next[1]);
        }
    }
}
