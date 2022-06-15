package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5567 {    // 결혼식
    static boolean[][] map;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            map[first][second] = true;
            map[second][first] = true;
        }

        visited = new boolean[n];
        visited[0] = true;
        dfs(0, 0);

        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (visited[i]) answer++;
        }
        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == 2) return;

        for (int i = 1; i < n; i++) {
            if (map[idx][i]) {
                visited[i] = true;
                dfs(depth + 1, i);
            }
        }
    }
}
