package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9625 {    // BABBA
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        if (k == 0) System.out.println("1 0");
        else {
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= k; i++) {
                int temp = dp[1];
                dp[1] += dp[0];
                dp[0] = temp;
            }
            System.out.println(dp[0] + " " + dp[1]);
        }
    }
}
