package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {    // 파도반 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            if (n >= 2) dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }
            System.out.println(dp[n]);
        }
    }
}
