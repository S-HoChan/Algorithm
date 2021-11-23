package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052 {   // 카드 구매하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            for (int j = 1; j <= i; j++) {
                temp = Math.max(temp, dp[i - j] + dp[j - 1]);
            }
            dp[i] = temp;
        }
        System.out.println(dp[n - 1]);
    }
}
