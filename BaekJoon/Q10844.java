package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {   // 쉬운 계단 수
    private static Long[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1][10]; // n자릿수에 대한 각각의 값(0 ~ 9)를 의미

        for (int i = 0; i < 10; i++) dp[1][i] = 1L;  // 첫 번째 자리는 1로 초기화

        long ans = 0;
        for (int i = 1; i <= 9; i++) ans += recur(n, i);
        System.out.println(ans % 1000000000);
    }

    private static long recur(int digit, int val) {
        if (digit == 1) return dp[digit][val];  // 첫 번째 자리에 도착하면 종료

        if (dp[digit][val] == null) {
            if (val == 0) dp[digit][val] = recur(digit - 1, 1); // 0일 경우 다음은 1만 가능
            else if (val == 9) dp[digit][val] = recur(digit - 1, 8);  // 9일 경우 8만 가능
            else dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
        }
        return dp[digit][val] % 1000000000;
    }
}
