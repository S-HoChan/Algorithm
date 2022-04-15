package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13171 {   // A
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1_000_000_007;
        long a = Long.parseLong(br.readLine());
        a %= MOD;
        long x = Long.parseLong(br.readLine());
        long answer = 1L;
        while (x > 0) {
            if ((x & 1) == 1) answer = answer * a % MOD;
            x >>= 1;
            a = a * a % MOD;
        }

        System.out.println(answer);
    }
}
