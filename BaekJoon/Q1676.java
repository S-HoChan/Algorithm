package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1676 {    // 팩토리얼 0의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }

        System.out.println(ans);
    }
}
