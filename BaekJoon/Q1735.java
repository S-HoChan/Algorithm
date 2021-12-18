package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1735 {    // 분수 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int b3 = b1 * b2;
        int a3 = a1 * b2 + a2 * b1;
        int mod = gcd(a3, b3);

        a3 /= mod;
        b3 /= mod;

        System.out.println(a3 + " " + b3);
    }

    static int gcd(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        if (n == 0) return m;
        return gcd(n, m % n);
    }
}
