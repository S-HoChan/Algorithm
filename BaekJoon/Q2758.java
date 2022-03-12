package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2758 {    // 로또
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long[][] dp = new long[n + 1][m + 1]; // N번째 수를 M으로 선택
            for (int i = 0; i <= m; i++)
                dp[0][i] = 1L;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
                }
            }
            sb.append(dp[n][m]).append('\n');
        }
        System.out.println(sb);
    }
}
