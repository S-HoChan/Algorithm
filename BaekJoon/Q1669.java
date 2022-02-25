package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1669 {    // 멍멍이 쓰다듬기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (x == y) {
            System.out.println(0);
        } else {
            int n = (int) Math.pow(y - x, 0.5);
            if (n * n == y - x) {
                System.out.println(2 * n - 1);
            } else {
                int diff = (y - x) - n * n;
                if (diff <= n) {
                    System.out.println(2 * n);
                } else {
                    System.out.println(2 * n + 1);
                }
            }
        }
    }
}
