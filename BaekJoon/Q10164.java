package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10164 {   // 격자상의 경로
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // row
        int m = Integer.parseInt(st.nextToken());   // col
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        dp[0][0] = 1;
        if (k == 0) sol(0, 0, n - 1, m - 1);
        else {
            int ky = (k - 1) / m;
            int kx = (k - 1) % m;
            sol(0, 0, ky, kx);
            sol(ky, kx, n - 1, m - 1);
            dp[n - 1][m - 1] /= 2;
        }
        System.out.println(dp[n - 1][m - 1]);
    }

    static void sol(int sy, int sx, int ey, int ex) {
        for (int y = sy; y <= ey; y++) {
            for (int x = sx; x <= ex; x++) {
                if (y > 0) dp[y][x] += dp[y - 1][x];
                if (x > 0) dp[y][x] += dp[y][x - 1];
            }
        }
    }
}
