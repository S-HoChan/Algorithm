package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1951 {    // 활자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long answer = 0;
        int temp = n;
        int digit = 0;  // 10^0
        while (temp > 0) {
            answer += (n - (int) Math.pow(10, digit++) + 1);
            temp /= 10;
        }
        System.out.println(answer % 1234567);
    }
}
