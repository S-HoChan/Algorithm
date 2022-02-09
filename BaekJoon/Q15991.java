package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15991 {   // 1, 2, 3 더하기 6
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[100001];
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1+1, 2
        dp[3] = 2;  // 1+1+1, 3
        dp[4] = 3;  // 1+1+1+1, 2+2, 1+2+1
        dp[5] = 3;  // 1+1+1+1+1, 2+1+2, 1+3+1
        dp[6] = 6;
        for (int i = 7; i <= 100000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1_000_000_009; // 1+x+1, 2+x+2, 3+x+3
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }
}
