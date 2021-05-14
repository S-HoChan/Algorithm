package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {   // 동전 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = coins.length - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < n && k > 0; i++) {
            if (coins[i] > k) continue;

            ans += k / coins[i];
            k = k % coins[i];
        }

        System.out.println(ans);
    }
}
