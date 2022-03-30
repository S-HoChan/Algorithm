package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q13699 {   // 점화식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            BigInteger temp = BigInteger.ZERO;
            for (int j = 0; j < i; j++) {
                temp = temp.add(dp[j].multiply(dp[i - 1 - j]));
            }
            dp[i] = temp;
        }
        System.out.println(dp[n]);
    }
}
