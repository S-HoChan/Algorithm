package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {    // 욕심쟁이 판다
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                answer = Math.max(answer, dfs(y, x));
            }
        }
        System.out.println(answer);
    }

    static int dfs(int y, int x) {
        if (dp[y][x] > 0) return dp[y][x];

        dp[y][x] = 1;   // init
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[y][x] >= map[ny][nx]) continue;

            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        }
        return dp[y][x];
    }
}
