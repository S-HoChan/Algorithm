package ProgrammersLevel4;

public class ThreeByNTiling {
    public int solution(int n) {
        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3; // 이전에 만든 경우의 수 * 3
            for (int j = i - 4; j >= 0; j -= 2) {  // 특수 모양 경우의 수 * 2
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % 1000000007;
        }

        return (int) dp[n];
    }
}
