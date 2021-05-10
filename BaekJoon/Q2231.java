package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2231 {    //분해합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String token = st.nextToken();
        int len = token.length();
        int n = Integer.parseInt(token);

        for (int i = (n - (len * 9)); i < n; i++) { // i 가능 최소값 = n - 9 * n의 길이
            int number = i;
            int sum = 0;
            while (number != 0) {
                sum += number % 10; // 각 자리수의 합
                number /= 10;
            }

            if (sum + i == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
