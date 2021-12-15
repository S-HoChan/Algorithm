package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10971 {   // 외판원 순회 2
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer = 1_000_000 * 10 * 10 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    static void dfs(int start, int now, int cnt, int sum) {
        if (cnt == n - 1) {
            if (map[now][start] != 0) {
                answer = Math.min(answer, sum + map[now][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cnt + 1, sum + map[now][i]);
                visited[i] = false;
            }
        }
    }
}
