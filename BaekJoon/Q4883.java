package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4883 {    // 삼각 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n][3];
            dp[0][0] = 1_000_001;
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][1] + arr[0][2];
            for (int y = 1; y < n; y++) {
                dp[y][0] = arr[y][0] + Math.min(dp[y - 1][0], dp[y - 1][1]);
                dp[y][1] = arr[y][1] + Math.min(dp[y - 1][0], Math.min(dp[y - 1][1], Math.min(dp[y - 1][2], dp[y][0])));
                dp[y][2] = arr[y][2] + Math.min(dp[y - 1][1], Math.min(dp[y - 1][2], dp[y][1]));
            }

            sb.append(++k).append(". ").append(dp[n - 1][1]).append('\n');
        }
        System.out.println(sb);
    }
}
