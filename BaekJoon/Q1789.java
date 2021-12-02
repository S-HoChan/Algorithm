package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1789 {    // 수들의 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0;
        int n = 1;
        while (sum < s) {
            sum += n++;
        }
        if (sum == s) System.out.println(n - 1);
        else System.out.println(n - 2);
    }
}
