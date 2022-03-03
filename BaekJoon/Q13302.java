package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13302 {   // 리조트
    static int n;
    static boolean[] holiday;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        holiday = new boolean[n + 1];
        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                holiday[Integer.parseInt(st.nextToken())] = true;
            }
        }

        dp = new int[n + 1][n / 2 + 1];
        System.out.println(sol(1, 0));
    }

    static int sol(int day, int coupon) {
        if (day > n) return 0;
        if (dp[day][coupon] > 0) return dp[day][coupon];

        if (holiday[day]) return dp[day][coupon] = sol(day + 1, coupon);

        if (coupon >= 3) dp[day][coupon] = sol(day + 1, coupon - 3);
        else dp[day][coupon] = 100 * 10_000 + 1;
        dp[day][coupon] = Math.min(dp[day][coupon],
                Math.min(sol(day + 1, coupon) + 10000,
                        Math.min(sol(day + 3, coupon + 1) + 25000,
                                sol(day + 5, coupon + 2) + 37000)));

        return dp[day][coupon];
    }
}
