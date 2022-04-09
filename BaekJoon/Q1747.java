package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1747 {    // 소수&팰린드롬
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[2_000_001];
        for (int i = 2; i <= 2_000_000; i++) {
            if (isNotPrime[i]) continue;

            if ((long) i * i <= 2_000_000) {
                for (int j = i * i; j <= 2_000_000; j += i)
                    isNotPrime[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(2);
            return;
        }

        for (int j = n; ; j++) {
            if (!isNotPrime[j] && isPalin(j)) {
                System.out.println(j);
                break;
            }
        }
    }

    static boolean isPalin(int n) {
        char[] temp = String.valueOf(n).toCharArray();
        for (int i = 0; i < temp.length / 2; i++) {
            if (temp[i] != temp[temp.length - 1 - i]) return false;
        }
        return true;
    }
}
