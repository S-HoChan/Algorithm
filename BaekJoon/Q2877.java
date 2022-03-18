package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2877 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine()) + 1;
        while (k > 0) {
            if (k % 2 == 0) sb.append(4);
            else sb.append(7);
            k /= 2;
        }
        System.out.println(sb.reverse().substring(1));
    }

    // 1 2 3  4  5  6  7   8   9   10  11
    // 4 7 44 47 74 77 444 447 474 477 744
    // 0 1 00 01 10 11 000 001 010 011 100
}
