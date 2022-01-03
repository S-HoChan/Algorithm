package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11048 {   // 이동하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                dp[y][x] = map[y][x];
            }
        }

        int[] dy = {-1, -1, 0};
        int[] dx = {-1, 0, -1};

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int temp = 0;
                for (int i = 0; i < 3; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    temp = Math.max(temp, dp[ny][nx]);
                }
                dp[y][x] += temp;
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
