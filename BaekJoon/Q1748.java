package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1748 {    // 수 이어 쓰기 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = String.valueOf(n).length();

        int answer = 0, temp = 9;
        for (int i = 1; i < len; i++) {
            answer += i * temp;
            temp *= 10;
        }

        answer += (n - Math.pow(10, len - 1) + 1) * len;
        System.out.println(answer);
    }
}
