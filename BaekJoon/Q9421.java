package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q9421 {    // 소수상근수
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                if (i < Math.sqrt(1000000)) {
                    for (int j = i * i; j <= 1000000; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i] && isOk(i)) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isOk(int n) { // 상근수 판별
        Set<Integer> set = new HashSet<>();
        int now = n;
        while (!set.contains(now)) {
            if (now == 1) return true;
            set.add(now);

            int next = 0;
            while (now > 0) {
                next += (now % 10) * (now % 10);
                now /= 10;
            }
            now = next;
        }
        return false;
    }
}
