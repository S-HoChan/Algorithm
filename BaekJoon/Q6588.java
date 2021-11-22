package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6588 {    // 골드바흐의 추측
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isNotPrime = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            if (n == 0) break;

            for (int i = 3; i <= n / 2; i += 2) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i)).append('\n');
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.").append('\n');
            }
        }
        System.out.println(sb);
    }
}
