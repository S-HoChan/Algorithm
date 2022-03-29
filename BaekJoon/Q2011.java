package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2011 {    // 암호코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        if (arr[0] == '0') {
            System.out.println(0);
            return;
        }

        final int MOD = 1_000_000;
        int[] dp = new int[arr.length + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= arr.length; i++) {
            char now = arr[i - 1], pre = arr[i - 2];
            if (now == '0') {
                if (pre == '1' || pre == '2') dp[i] = dp[i - 2] % MOD;
                else {
                    System.out.println(0);
                    return;
                }
            } else if (pre == '0') {
                dp[i] = dp[i - 1] % MOD;
            } else {
                if (pre == '1' || (pre == '2' && now <= '6')) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                } else dp[i] = dp[i - 1] % MOD;
            }
        }
        System.out.println(dp[arr.length]);
    }
}
