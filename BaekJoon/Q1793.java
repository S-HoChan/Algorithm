package BaekJoon;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Q1793 {    // 타일링
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= 250; i++) {
            dp[i] = dp[i - 2].add(dp[i - 2]);
            dp[i] = dp[i].add(dp[i - 1]);
        }

        while (sc.hasNextInt()) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
