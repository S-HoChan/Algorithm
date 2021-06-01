package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {    // 곱셈
    private static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a, b));
    }

    private static long pow(long a, long exponent) {
        if (exponent == 1) return a % c;

        long temp = pow(a, exponent / 2);
        if (exponent % 2 == 1) return (temp * temp % c) * a % c;
        else return temp * temp % c;
    }
}
