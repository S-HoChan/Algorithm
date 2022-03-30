package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {   // 파이프 옮기기 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];    // true : wall
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int[][][] dp = new int[n][n][3];    // 0 : 가로, 1 : 대각선, 2 : 세로
        dp[0][1][0] = 1;
        for (int y = 0; y < n; y++) {
            for (int x = y == 0 ? 2 : 0; x < n; x++) {
                if (map[y][x]) continue;

                if (x > 0) dp[y][x][0] += dp[y][x - 1][0] + dp[y][x - 1][1];
                if (y > 0) dp[y][x][2] += dp[y - 1][x][2] + dp[y - 1][x][1];
                if (x > 0 && y > 0 && !map[y - 1][x] && !map[y][x - 1])
                    dp[y][x][1] = dp[y - 1][x - 1][0] + dp[y - 1][x - 1][2] + dp[y - 1][x - 1][1];
            }
        }
        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}
