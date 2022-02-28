package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18222 {   // 투에-모스 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(sol(n));
    }

    static long sol(long n) {
        if (n == 1) return 0;
        long i; // n보다 작은 2의 거듭제곱
        for (i = 1; i + i < n; i += i) ;
        return 1 - sol(n - i);
    }
}
