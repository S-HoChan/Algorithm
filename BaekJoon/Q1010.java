package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010 {    // 다리 놓기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int _t = 0; _t < t; _t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[m + 1][n + 1]; // nCr
            for (int i = 1; i <= m; i++) {    // n
                for (int j = 0; j <= i && j <= n; j++) {    // r
                    if (i == j || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            sb.append(dp[m][n]).append('\n');
        }

        System.out.println(sb);
    }
}
