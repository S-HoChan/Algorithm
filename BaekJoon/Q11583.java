package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11583 {   // 인경호의 징검다리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n][2]; // 2, 5
            dp[0][0] = getCnt(arr[0], 2);
            dp[0][1] = getCnt(arr[0], 5);
            for (int i = 1; i < n; i++) {
                dp[i][0] = Integer.MAX_VALUE;
                dp[i][1] = Integer.MAX_VALUE;
                for (int j = i - 1; i - j <= k && j >= 0; j--) {
                    dp[i][0] = Math.min(dp[i][0], dp[j][0] + getCnt(arr[i], 2));
                    dp[i][1] = Math.min(dp[i][1], dp[j][1] + getCnt(arr[i], 5));
                }
            }

            sb.append(Math.min(dp[n - 1][0], dp[n - 1][1])).append('\n');
        }
        System.out.println(sb);
    }

    static int getCnt(int num, int target) {
        int temp = 0;
        while (num % target == 0) {
            temp++;
            num /= target;
        }
        return temp;
    }
}
