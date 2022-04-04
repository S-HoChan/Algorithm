package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14606 {   // 피자 (Small)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= 10; i++) {
            int first = i / 2;
            int second = i / 2 + i % 2;
            dp[i] = dp[first] + dp[second] + first * second;
        }
        System.out.println(dp[n]);
    }
}
