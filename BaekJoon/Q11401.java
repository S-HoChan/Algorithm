package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11401 {   // 이항 계수 3
    final static long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long numer = fact(n);   // 분자 n!
        long denom = fact(k) * fact(n - k) % P;    // 분모 (k! * (n-k)!)

        System.out.println(numer * pow(denom, P - 2) % P);  // 페르마의 소정리
    }

    private static long fact(long n) {
        long ans = 1L;
        while (n > 1) {
            ans = (ans * n--) % P;
        }
        return ans;
    }

    private static long pow(long base, long expo) {
        if (expo == 1) return base % P;

        long temp = pow(base, expo / 2);
        if (expo % 2 == 1) return (temp * temp % P) * base % P;
        else return temp * temp % P;
    }
}
