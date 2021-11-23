package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13301 {   // 타일 장식물
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(4);
            return;
        }

        long[] dp = new long[n + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long answer = 2 * (dp[n] + dp[n + 1]);
        System.out.println(answer);
    }
}
