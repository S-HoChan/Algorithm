package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2553 {    // 마지막 팩토리얼 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[20001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 6;
        dp[4] = 4;

        for (int i = 5; i <= n; i++) {
            if (i % 5 == 0) {
                int divFive = i / 5;
                dp[i] = ((int) Math.pow(2, divFive % 4) * dp[divFive]) % 10;
            } else {
                int preFive = i / 5 * 5;
                int temp = 1;
                for (int j = preFive + 1; j <= i; j++) {
                    temp *= (j % 10);
                }
                temp *= dp[preFive];
                dp[i] = temp % 10;
            }
        }
        System.out.println(dp[n]);
    }
}
