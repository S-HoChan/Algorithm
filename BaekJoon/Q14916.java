package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14916 {   // 거스름돈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1 || n == 3) {
            System.out.println(-1);
        } else if (n == 2) {
            System.out.println(1);
        } else if (n == 4) {
            System.out.println(2);
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 100001;
            dp[2] = 1;
            dp[3] = 100001;
            dp[4] = 2;
            for (int i = 5; i <= n; i++) {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
            }
            System.out.println(dp[n]);
        }
    }
}
