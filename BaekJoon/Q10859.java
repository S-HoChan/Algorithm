package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10859 {   // 뒤집어진 소수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        if (!isPrime(Long.parseLong(n))) {
            System.out.println("no");
            return;
        }

        StringBuilder trans = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            char now = n.charAt(i);
            if (now == '3' || now == '4' || now == '7') {
                System.out.println("no");
                return;
            }

            if (now == '6') trans.append(9);
            else if (now == '9') trans.append(6);
            else trans.append(now);
        }

        System.out.println(isPrime(Long.parseLong(trans.reverse().toString())) ? "yes" : "no");
    }

    static boolean isPrime(long n) {
        if (n == 1) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
