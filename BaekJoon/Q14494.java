package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14494 {   // 다이나믹이 뭐예요?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = (int) (((long) dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007);
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
