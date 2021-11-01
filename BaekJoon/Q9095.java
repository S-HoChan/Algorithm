package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {    // 1, 2, 3 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            if (n >= 2) dp[2] = 2;  // 11 2
            if (n >= 3) dp[3] = 4;  // 111 12 21 3
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }
}
