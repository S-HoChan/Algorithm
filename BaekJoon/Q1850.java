package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1850 {    // 최대공약수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        StringBuilder sb = new StringBuilder();
        long n = gcd(a, b);
        for (long i = 0; i < n; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        long m = Math.max(a, b);
        long n = Math.min(a, b);
        if (n == 0) return m;
        return gcd(n, m % n);
    }
}
