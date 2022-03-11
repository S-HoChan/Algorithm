package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q4134 {    // 다음 소수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            BigInteger now = new BigInteger(br.readLine());
            if (now.isProbablePrime(10)) sb.append(now);
            else sb.append(now.nextProbablePrime());
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
