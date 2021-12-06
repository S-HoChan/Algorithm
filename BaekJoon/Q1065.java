package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1065 {    // 한수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 100) {
            System.out.println(n);
            return;
        }

        int answer = 99;
        if (n == 1000) n = 999;

        for (int i = 100; i <= n; i++) {
            int hun = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            if ((hun - ten) == (ten - one)) answer++;
        }

        System.out.println(answer);
    }
}
