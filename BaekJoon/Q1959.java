package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1959 {    // 달팽이3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int cnt = 0;
        if (m > n) cnt = (n - 1) * 2 + 1;
        else cnt = (m - 1) * 2;

        int y, x;
        if (m > n) {
            if (n % 2 == 0) {
                y = n / 2 + 1;
                x = n / 2;
            } else {
                y = n / 2 + 1 + (m - n);
                x = n / 2 + 1;
            }
        } else if (m == n) {
            y = m / 2 + 1;
            if (m % 2 == 1) {
                x = n / 2 + 1;
            } else x = n / 2;
        } else {
            y = m / 2 + 1;
            if (m % 2 == 0) {
                x = m / 2;
            } else x = m / 2 + 1 + (n - m);
        }

        System.out.println(cnt);
        System.out.println(y + " " + x);
    }
}
