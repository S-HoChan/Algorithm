package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1110 {    // 더하기 사이클
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int temp = n;
        while (true) {
            count++;
            int num1 = temp % 10;
            int num2 = (temp % 10 + temp / 10);
            num2 = num2 >= 10 ? num2 - 10 : num2;
            temp = num1 * 10 + num2;

            if (temp == n) break;
        }
        System.out.println(count);
    }
}
