package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4948 {    // 베르트랑 공준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while (n != 0) {
            boolean[] prime = new boolean[n * 2 + 1];
            prime[0] = prime[1] = true;
            int cnt = 0;

            for (int i = 2; i <= n * 2; i++) {
                if (prime[i]) continue;

                for (int j = i + i; j <= n * 2; j += i) prime[j] = true;
            }

            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i]) cnt++;
            }
            System.out.println(cnt);

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
    }
}
