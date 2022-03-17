package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18249 {   // 욱제가 풀어야 하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[191230];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 191229; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % (int) (1e9 + 7);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');

        }
        System.out.println(sb);
    }
}
