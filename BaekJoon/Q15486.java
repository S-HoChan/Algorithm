package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15486 {   // 퇴사 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int next = i + arr[i][0];
            max = Math.max(max, dp[i]);
            if (next > n) continue;
            dp[next] = Math.max(dp[next], max + arr[i][1]);
        }
        System.out.println(max);
    }
}
