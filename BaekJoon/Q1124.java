package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1124 {    // 언더프라임
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        isNotPrime = new boolean[100001]; // 에라토스테네스의 체
        for (int i = 2; i * i <= 100000; i++) {
            for (int j = i + i; j <= 100000; j += i) {
                isNotPrime[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = a; i <= b; i++) {
            int ae = primeFactor(i);
            if (ae > 1 && !isNotPrime[ae]) answer++;
        }
        System.out.println(answer);
    }

    static int primeFactor(int n) {
        int count = 0;
        while (isNotPrime[n]) {
            for (int i = 2; i <= 100000; i++) {
                if (!isNotPrime[i] && n % i == 0) {
                    n /= i;
                    count++;
                    break;
                }
            }
        }
        if (n > 1) count++;
        return count;
    }
}
