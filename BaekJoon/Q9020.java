package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9020 {    // 골드바흐의 추측
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int tt = 0; tt < t; tt++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean[] prime = new boolean[n + 1];
            prime[0] = prime[1] = true;
            for (int i = 2; i <= n; i++) {
                if (prime[i]) continue;

                for (int j = i + i; j <= n; j += i) {
                    prime[j] = true;
                }
            }

            int left = n / 2, right = n / 2;
            while (true) {
                if (prime[left]) {
                    left--;
                    continue;
                }
                if (prime[right]) {
                    right++;
                    continue;
                }

                if (left + right == n) break;
                else if (left + right > n) left--;
                else right++;
            }
            System.out.println(left + " " + right);
        }
    }
}
