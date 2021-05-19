package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11051 {   // 이항 계수 2
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        System.out.println(comb(n, k));
    }

    static int comb(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];

        if (r == 0 || n == r) return dp[n][r] = 1;

        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
