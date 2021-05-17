package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {    // 계단 오르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[0]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = stairs[0];
        dp[2] = dp[1] + stairs[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = stairs[i - 1] + Math.max(dp[i - 2], dp[i - 3] + stairs[i - 2]);
        }

        System.out.println(dp[n]);
    }
}
