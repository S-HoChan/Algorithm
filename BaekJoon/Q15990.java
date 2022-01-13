package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15990 {   // 1, 2, 3 더하기 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int m = 0;
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            m = Math.max(m, arr[i]);
        }
        long[][] dp = new long[m + 1][4];
        dp[1][1] = 1;   // 1
        if (m >= 2) dp[2][2] = 1;   // 2
        if (m >= 3) {
            dp[3][1] = 1;   // 2 + 1
            dp[3][2] = 1;   // 1 + 2
            dp[3][3] = 1;   // 3
        }
        for (int i = 4; i <= m; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
        }
        for (int i = 0; i < t; i++) {
            sb.append((dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % 1_000_000_009).append('\n');
        }
        System.out.println(sb);
    }
}
