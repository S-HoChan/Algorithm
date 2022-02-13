package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12871 {   // 무한 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        if (s.length() != t.length()) {
            int lcm = s.length() * t.length() / gcd(s.length(), t.length());
            String originS = s;
            String originT = t;
            while (s.length() < lcm) s += originS;
            while (t.length() < lcm) t += originT;
        }
        System.out.println(s.equals(t) ? 1 : 0);
    }

    static int gcd(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
