package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {    // 포도주 시식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        dp[2] = dp[1] + arr[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = arr[i - 1] + Math.max(dp[i - 3] + arr[i - 2], dp[i - 2]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
