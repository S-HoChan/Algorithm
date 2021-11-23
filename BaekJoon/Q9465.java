package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {    // 스티커
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n + 1][2];
            dp[1][0] = arr[0][0];
            dp[1][1] = arr[0][1];
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + arr[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i - 1][1];
            }
            sb.append(Math.max(dp[n][0], dp[n][1])).append('\n');
        }
        System.out.println(sb);
    }
}
