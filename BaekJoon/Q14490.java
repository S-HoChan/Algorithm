package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14490 {   // 백대열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(":");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int g = gcd(n, m);
        System.out.println(n / g + ":" + m / g);
    }

    static int gcd(int n, int m) {
        int a = Math.max(n, m);
        int b = Math.min(n, m);
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
