package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {    // RGB거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                if (i == 0) dp[i][j] = Integer.parseInt(st.nextToken());
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; k++) {
                        if (j == k) continue;
                        min = Math.min(min, dp[i - 1][k]);
                    }
                    dp[i][j] = Integer.parseInt(st.nextToken()) + min;
                }
            }
        }

        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}
